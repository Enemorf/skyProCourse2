package enerlo.jc2.interfaces;

import enerlo.jc2.Question;
import java.util.Collection;

public interface ExaminerService
{
    Collection<Question> getQuestions(int amount);
}
