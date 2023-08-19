package enerlo.jc2.services;

import enerlo.jc2.Question;

import java.util.Set;

public class ConstantsTest
{
    public static final Question QUESTION_1 = new Question("What is the answer to life, the universe and everything?", "42");
    public static final Question QUESTION_2 = new Question("Как тебя зовут?", "Enerlo");
    public static final Question QUESTION_3 = new Question("Какая твоа любимая книжка?", "Бумажная");
    public static final Question QUESTION_4 = new Question("Какой твой любимой компьютер?", "Игровой");
    public static final Question QUESTION_5 = new Question("Какой твой любимой телевизор?", "Жидко-кристаллический");

    public static final Set<Question> QUESTIONS = Set.of(
            QUESTION_1,
            QUESTION_2,
            QUESTION_3,
            QUESTION_4,
            QUESTION_5
    );
}
