package enerlo.jc2.services;

import enerlo.jc2.Question;
import enerlo.jc2.exceptions.TooManyCallsException;
import enerlo.jc2.interfaces.ExaminerService;
import enerlo.jc2.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService
{
    private QuestionService javaQuestionService;
    private QuestionService mathQuestionService;
    private Random random;

    public ExaminerServiceImpl(@Qualifier("java") QuestionService javaQuestionService,@Qualifier("math") QuestionService mathQuestionService)
    {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
        random = new Random();
    }
    @Override
    public Collection<Question> getQuestions(int amount)
    {
        int size = javaQuestionService.getAllQuestions().size() + mathQuestionService.getAllQuestions().size();
        Set<Question> questions = new HashSet<>();
        Question question;

        if(amount > size)
            throw new TooManyCallsException("Превышен лимит вызова метода");

        while(amount > 0)
        {
            if(random.nextBoolean())
                question = javaQuestionService.getRandomQuestion();
            else
                question = mathQuestionService.getRandomQuestion();

            if(!questions.contains(question)) {
                questions.add(question);
                amount--;
            }
        }

        return questions;
    }
}
