package enerlo.jc2.services;

import enerlo.jc2.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;

import static enerlo.jc2.services.ConstantsTest.*;
import static org.junit.jupiter.api.Assertions.*;


import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest
{
    @Mock
    private JavaQuestionService javaServiceMock;
    @Mock
    private MathQuestionService mathQuestionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl out;


    @Test
    public void getQuestionsTest()
    {
        when(javaServiceMock.getRandomQuestion()).thenReturn(QUESTION_1);
        when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(QUESTION_2);

        doReturn(1).when(javaServiceMock).getAllQuestions().size();
        doReturn(1).when(mathQuestionServiceMock).getAllQuestions().size();

        Question[] actQuest = new Question[] {QUESTION_1, QUESTION_2};

        assertEquals(actQuest, out.getQuestions(2).toArray());
    }


}
