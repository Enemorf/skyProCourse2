package enerlo.jc2.services;

import enerlo.jc2.Question;
import enerlo.jc2.exceptions.MethodNotAllowedException;
import enerlo.jc2.interfaces.QuestionRepository;
import enerlo.jc2.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.HashSet;

@Service("math")
public class MathQuestionService implements QuestionService
{

    public MathQuestionService()
    {
    }

    @Override
    public Question addQuestion(String question, String answer)
    {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question addQuestion(Question question)
    {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question removeQuestion(Question question)
    {
        throw new MethodNotAllowedException();
    }

    @Override
    public Collection<Question> getAllQuestions()
    {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question getRandomQuestion()
    {
        return randomMathQuestion();
    }


    private Question randomMathQuestion()
    {
        Random random = new Random();
        int a = random.nextInt(-100,+100);
        int b = random.nextInt(-100,+100);
        double result = 0;

        switch (random.nextInt(4)) {
            case 0 -> {
                    return new Question("Сколько будет " + a + (b >=0 ? " + ": " - ") + b + " ?",
                            Integer.toString(a + b));
            }
            case 1 -> {
                return new Question("Сколько будет " + a + (b >=0 ? " - ": " + ") + b + " ?",
                            Integer.toString(a - b));
            }
            case 2 -> {
                return new Question("Сколько будет " + a + " * " + b + " ?",
                            Integer.toString(a * b));
            }
            case 3 -> {
                return new Question("Сколько будет " + a + " / " + (b == 0 ? b = 1 : b) + " ?",
                            Double.toString((double)a / b));
            }
        }
        return null;
    }
}
