package enerlo.jc2.repository;

import enerlo.jc2.Question;
import enerlo.jc2.exceptions.QuestionsNotFoundException;
import enerlo.jc2.interfaces.QuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository("mathRep")
public class MathQuestionRepository implements QuestionRepository
{
    private final Set<Question> questions;

    public MathQuestionRepository()
    {
        questions = new HashSet<>();
    }

    @Override
    public Question add(Question question)
    {
        questions.add(question);
        return question;
    }

    @Override
    public Question find(Question question)
    {
        if(!questions.contains(question))
            throw new QuestionsNotFoundException("Вопрос не найден!");
        return question;
    }

    @Override
    public Question remove(Question question)
    {
        if(!questions.contains(question))
            throw new QuestionsNotFoundException("Вопрос не найден!");
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll()
    {
        return questions;
    }

    @PostConstruct
    public void init()
    {
        questions.add(new Question("Сколько будет 2+2","4"));
        questions.add(new Question("Сколько будет 5*3","15"));
        questions.add(new Question("Сколько будет 20/2","10"));
        questions.add(new Question("Сколько будет 11^2","121"));
        questions.add(new Question("Сколько будет 144^0,5","12"));
    }
}
