package enerlo.jc2.services;
import enerlo.jc2.Question;
import enerlo.jc2.exceptions.MethodNotAllowedException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static enerlo.jc2.services.ConstantsTest.*;
import static org.junit.jupiter.api.Assertions.*;


public class MathQuestionServiceTest
{
    //Проверяю, что вылетает ошибка и что вылетает рандомный вопрос
    private final MathQuestionService out = new MathQuestionService();
    public static Stream<Arguments> PARAMS_FOR_ADD_QUEST()
    {
        return Stream.of(
                Arguments.of(QUESTION_1),
                Arguments.of(QUESTION_2),
                Arguments.of(QUESTION_3),
                Arguments.of(QUESTION_4),
                Arguments.of(QUESTION_5)
        );
    }
    @ParameterizedTest
    @MethodSource("PARAMS_FOR_ADD_QUEST")
    public void MethodNotAllowedExceptionTest(Question question)
    {
        assertThrows(MethodNotAllowedException.class, () -> out.addQuestion(question));
        assertThrows(MethodNotAllowedException.class, () -> out.removeQuestion(question));
        assertThrows(MethodNotAllowedException.class, out::getAllQuestions);
    }


    @Test
    public void getRandomQuestionTest()
    {
        //проверяю, что выдается рандомный вопрос
        assertNotNull(out.getRandomQuestion());
    }
}
