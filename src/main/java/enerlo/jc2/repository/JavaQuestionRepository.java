package enerlo.jc2.repository;

import enerlo.jc2.Question;
import enerlo.jc2.exceptions.QuestionAlreadyAddedException;
import enerlo.jc2.exceptions.QuestionsNotFoundException;
import enerlo.jc2.interfaces.QuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository ("javaRep")
public class JavaQuestionRepository implements QuestionRepository
{
    private final Set<Question> questions;

    public JavaQuestionRepository()
    {
        questions = new HashSet<>();
    }

    @Override
    public Question add(Question question)
    {
        if(questions.contains(question))
            throw new QuestionAlreadyAddedException("Вопрос уже добавлен в коллекцию!");
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
        questions.add(new Question("Перечисли принципы ООП","Инкапсуляция, наследование, полиморфизм"));
        questions.add(new Question("Что такое коллекции?","Динамические хранилища данных, реализующие интерфейс Collection"));
        questions.add(new Question("Является ли Hash коллекцией?","Нет"));
        questions.add(new Question("Где хранятся ссылочные типы данных в памяти?","В области памяти \"куча\""));
    }
}
