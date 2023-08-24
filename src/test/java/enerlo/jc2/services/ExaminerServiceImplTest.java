package enerlo.jc2.services;

import enerlo.jc2.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static enerlo.jc2.services.ConstantsTest.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

        Collection<Question> questions = out.getQuestions(2);

        assertEquals(2, questions.size());
    }


}
