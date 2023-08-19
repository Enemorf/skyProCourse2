package enerlo.jc2.interfaces;

import enerlo.jc2.Question;
import java.util.Collection;

public interface QuestionService
{
    Question addQuestion(String question, String answer);
    Question addQuestion(Question question);
    Question removeQuestion(Question question);
    Collection<Question> getAllQuestions();
    Question getRandomQuestion();

}
