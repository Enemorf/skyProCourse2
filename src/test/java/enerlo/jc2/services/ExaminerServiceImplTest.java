package enerlo.jc2.services;

import enerlo.jc2.Question;
import enerlo.jc2.interfaces.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static enerlo.jc2.services.ConstantsTest.QUESTION_1;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static enerlo.jc2.services.ConstantsTest.QUESTIONS;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest
{
    @Mock
    private JavaQuestionService questionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl out;


    @Test
    public void getQuestionsTest()
    {
        when(questionServiceMock.getRandomQuestion()).thenReturn(QUESTION_1);

        assertDoesNotThrow(()-> out.getQuestions(1));

        assertEquals(QUESTION_1, out.getQuestions(1).toArray()[0]);
    }


}
