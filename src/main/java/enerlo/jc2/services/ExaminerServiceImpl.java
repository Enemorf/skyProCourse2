package enerlo.jc2.services;

import enerlo.jc2.Question;
import enerlo.jc2.exceptions.TooManyCallsException;
import enerlo.jc2.interfaces.ExaminerService;
import enerlo.jc2.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService
{
    private Random random;
    private QuestionService questionService;


    public ExaminerServiceImpl(QuestionService questionService) {
        this.random = new Random();
        this.questionService = questionService;
    }

    public ExaminerServiceImpl()
    {
        this.random = new Random();
        this.questionService = null;
    }
    @Override
    public Collection<Question> getQuestions(int amount)
    {
        int count = 0;
        Set<Question> questions = new HashSet<>();
        for(int i = 0; i < amount;)
        {
            if(count > questions.size())
                throw new TooManyCallsException("Превышен лимит вызова метода");

            Question question = questionService.getRandomQuestion();

            if(!questions.contains(question))
            {
                questions.add(question);
                i++;
            }
            count++;
        }
        return questions;
    }
}
