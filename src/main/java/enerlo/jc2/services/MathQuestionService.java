package enerlo.jc2.services;

import enerlo.jc2.Question;
import enerlo.jc2.interfaces.QuestionRepository;
import enerlo.jc2.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("math")
public class MathQuestionService implements QuestionService
{
    private final QuestionRepository questionRepository;
    private Random random;

    public MathQuestionService(@Qualifier("mathRep") QuestionRepository questionRepository)
    {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question addQuestion(String question, String answer)
    {
        return questionRepository.add(new Question(question,answer));
    }

    @Override
    public Question addQuestion(Question question)
    {
        return questionRepository.add(question);
    }

    @Override
    public Question removeQuestion(Question question)
    {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAllQuestions()
    {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion()
    {
        random = new Random();
        Collection<Question> tempQuest = questionRepository.getAll();
        int index = random.nextInt(tempQuest.size());
        return new ArrayList<>(tempQuest).get(index);
    }
}
