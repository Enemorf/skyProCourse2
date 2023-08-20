package enerlo.jc2.services;

import enerlo.jc2.Question;
import enerlo.jc2.repository.JavaQuestionRepository;
import enerlo.jc2.repository.MathQuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

import static enerlo.jc2.services.ConstantsTest.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathQuestionRepositoryTest
{
    private final MathQuestionRepository out = new MathQuestionRepository();

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
    public void addTest(Question question)
    {
        assertEquals(question, out.add(question));
    }

    @ParameterizedTest
    @MethodSource("PARAMS_FOR_ADD_QUEST")
    public void findTest(Question question)
    {
        out.add(question);
        assertEquals(question,out.find(question));
    }

    @ParameterizedTest
    @MethodSource("PARAMS_FOR_ADD_QUEST")
    public void removeTest(Question question)
    {
        out.add(question);
        assertEquals(question,out.remove(question));
    }

    @Test
    public void getAllTest()
    {
        HashSet<Question> tmp = new HashSet<>();
        tmp.add(QUESTION_1);
        out.add(QUESTION_1);
        tmp.add(QUESTION_2);
        out.add(QUESTION_2);

        assertArrayEquals(new HashSet[]{tmp}, new Collection[]{out.getAll()});

    }



}
