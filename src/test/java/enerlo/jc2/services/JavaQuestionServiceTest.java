package enerlo.jc2.services;

import enerlo.jc2.Question;
import enerlo.jc2.repository.JavaQuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static enerlo.jc2.services.ConstantsTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest
{
    private final Set<Question> questions = new HashSet<>();
    @Mock
    private JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    private JavaQuestionService out;

    public static Stream<Arguments> PARAMS_FOR_ADD()
    {
        return Stream.of(
                Arguments.of(QUESTION_1.getQuestion(),QUESTION_1.getAnswer()),
                Arguments.of(QUESTION_2.getQuestion(),QUESTION_2.getAnswer()),
                Arguments.of(QUESTION_3.getQuestion(), QUESTION_3.getAnswer())
        );
    }
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
    @MethodSource("PARAMS_FOR_ADD")
    public void addTest(String question, String answer)
    {
        Question quest = new Question(question, answer);

        when(javaQuestionRepository.add(any())).thenReturn(quest);
        assertEquals(out.addQuestion(question, answer), quest);
    }

    @ParameterizedTest
    @MethodSource("PARAMS_FOR_ADD_QUEST")
    public void addQuestionsTest(Question question)
    {
        when(javaQuestionRepository.add(any())).thenReturn(question);
        assertEquals(out.addQuestion(question),question);
    }

    @ParameterizedTest
    @MethodSource("PARAMS_FOR_ADD_QUEST")
    public void removeQuestionTest(Question question)
    {
        when(javaQuestionRepository.remove(any())).thenReturn(question);
        assertEquals(out.removeQuestion(question),question);
    }

    @Test
    public void getAllQuestionsTest()
    {
        when(javaQuestionRepository.getAll()).thenReturn(QUESTIONS);
        assertEquals(out.getAllQuestions(),QUESTIONS);
    }












}
