package enerlo.jc2.services;

import enerlo.jc2.Question;
import enerlo.jc2.exceptions.QuestionAlreadyAddedException;
import enerlo.jc2.exceptions.QuestionsNotFoundException;
import org.junit.jupiter.api.Test;

import static enerlo.jc2.services.ConstantsTest.*;
import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest
{
    private final JavaQuestionService out = new JavaQuestionService();

    @Test
    public void addNewQuestionTest()
    {
        assertEquals(QUESTION_1,  out.addQuestion(QUESTION_1));
        assertEquals(QUESTION_1, out.addQuestion("What is the answer to life, the universe and everything?","42"));
    }

    @Test
    public void addAlreadyAddedQuestionsTest()
    {
        out.addQuestion(QUESTION_2);
        assertThrows(QuestionAlreadyAddedException.class, () -> out.addQuestion(QUESTION_2));
    }

    @Test
    public void removeQuestionsTest()
    {
        out.addQuestion(QUESTION_3);
        assertEquals(QUESTION_3, out.removeQuestion(QUESTION_3));
        assertFalse(out.getAllQuestions().contains(QUESTION_3));
    }

    @Test
    public void removeNorFoundQuestionsTest()
    {
        assertThrows(QuestionsNotFoundException.class,()-> out.removeQuestion(QUESTION_4));
    }

    @Test
    public void getRandomQuestionsTest()
    {
        out.addQuestion(QUESTION_5);
        out.addQuestion(QUESTION_1);
        out.addQuestion(QUESTION_2);
        Question res = out.getRandomQuestion();
        assertTrue(res == QUESTION_1 || res == QUESTION_2 || res == QUESTION_5);
    }



}
