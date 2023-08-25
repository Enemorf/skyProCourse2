package enerlo.jc2.controllers;

import enerlo.jc2.Question;
import enerlo.jc2.interfaces.QuestionService;
import enerlo.jc2.services.JavaQuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController
{
    private final QuestionService javaQuestionService;

    public JavaQuestionController (@Qualifier("java") QuestionService javaQuestionService)
    {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question add (@RequestParam("question") String question, @RequestParam("answer") String answer)
    {
        return javaQuestionService.addQuestion(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question, @RequestParam("answer") String answer)
    {
        return javaQuestionService.removeQuestion(new Question(question,answer));
    }

    @GetMapping("")
    public Collection<Question> getAll() {
        return javaQuestionService.getAllQuestions();
    }

}
