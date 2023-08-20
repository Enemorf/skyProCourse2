package enerlo.jc2.interfaces;

import enerlo.jc2.Question;

import java.util.Collection;

public interface QuestionRepository
{
    Question add(Question question);
    Question find(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
}
