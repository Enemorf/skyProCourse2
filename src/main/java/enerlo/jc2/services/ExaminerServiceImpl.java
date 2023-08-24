package enerlo.jc2.services;

import enerlo.jc2.Question;
import enerlo.jc2.exceptions.TooManyCallsException;
import enerlo.jc2.interfaces.ExaminerService;
import enerlo.jc2.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.ArrayList;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService javaQuestionService;
    private QuestionService mathQuestionService;
    private Random random;

    public ExaminerServiceImpl(@Qualifier("java") QuestionService javaQuestionService, @Qualifier("math") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
        random = new Random();
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        List<QuestionService> services = new ArrayList<>();
            services.add(javaQuestionService);
            services.add(mathQuestionService);
        Question question;

//Не проверяется, ибо мы всегда можем дополнить рандомными математическими вопросами
//        int size = services.get(0).getAllQuestions().size() + random.nextInt(0,amount+1);
//        if(amount > size) {
//            throw new TooManyCallsException();
//        }

        while (amount > 0) {
            if (random.nextBoolean()) {
                question = services.get(0).getRandomQuestion();
            }
            else {
                question = services.get(1).getRandomQuestion();
            }
            if (!questions.contains(question)) {
                questions.add(question);
                amount--;
            }
        }
        return questions;
    }
}
