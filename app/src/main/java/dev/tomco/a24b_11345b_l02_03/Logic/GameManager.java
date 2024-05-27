package dev.tomco.a24b_11345b_l02_03.Logic;

import java.util.ArrayList;
import java.util.List;

import dev.tomco.a24b_11345b_l02_03.Model.Country;

public class GameManager {

    private List<Country> allCountries;
    private int score = 0;

    private int questionIndex = 0;
    private int wrongAnswers = 0;
    private int life;
    private static final int ANSWER_POINTS = 10;

    public GameManager() {
        this(3);
    }

    public GameManager(int life) {
        this.life = life;
        allCountries = DataManager.getCountries();
    }

    public List<Country> getAllCountries() {
        return allCountries;
    }

    public int getScore() {
        return score;
    }

    public int getQuestionIndex() {

        return questionIndex;
    }

    public Country getCurrentCountry() {
        return allCountries.get(getQuestionIndex());
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public int getLife() {
        return life;
    }

    public boolean isGameEnded() {
        return getQuestionIndex() == allCountries.size();
    }
    public boolean isGameLost() {
        return getLife() == getWrongAnswers();
    }

    public void checkAnswer(boolean answer){
        if (getCurrentCountry().isCanEnter() == answer)
            score += ANSWER_POINTS;
        else
            wrongAnswers++;
        questionIndex++;
    }
}
