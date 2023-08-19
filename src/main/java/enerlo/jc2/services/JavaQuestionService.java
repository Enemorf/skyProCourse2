package enerlo.jc2.services;

import enerlo.jc2.Question;
import enerlo.jc2.exceptions.QuestionAlreadyAddedException;
import enerlo.jc2.exceptions.QuestionsNotFoundException;
import enerlo.jc2.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService
{
    private Set<Question> questions;

    public JavaQuestionService()
    {
        questions = new HashSet<>();
    }

    @Override
    public Question addQuestion(String question, String answer)
    {
        Question newQuestion = new Question(question, answer);
        if(questions.contains(newQuestion))
            throw new QuestionAlreadyAddedException("Вопрос уже добавлен в коллекцию!");
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question addQuestion(Question question)
    {
        if(questions.contains(question))
            throw new QuestionAlreadyAddedException("Вопрос уже добавлен в коллекцию!");
        questions.add(question);
        return question;
    }

    @Override
    public Question removeQuestion(Question question)
    {
        if(!questions.contains(question))
            throw new QuestionsNotFoundException("Вопрос не найден");
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAllQuestions()
    {
        return questions;
    }

    @Override
    public Question getRandomQuestion()
    {
        Random random = new Random();
        int index = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(index);
    }
}
