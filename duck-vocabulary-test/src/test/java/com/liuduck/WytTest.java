package com.liuduck;

import com.liuduck.controller.TestController;
import com.liuduck.enums.ScoreIncrementEnum;
import org.junit.jupiter.api.Test;

public class WytTest {

    @Test
    void sql() {
        System.out.println(calScore(5000, true, 0));
        System.out.println(calScore(5000, true, 1));
        System.out.println(calScore(5000, true, 2));
        System.out.println(calScore(5000, true, 3));
        System.out.println(calScore(5000, true, 4));
        System.out.println(calScore(5000, true, 5));

        System.out.println(calScore(5000, false, 0));
        System.out.println(calScore(5000, false, 1));
        System.out.println(calScore(5000, false, 2));
        System.out.println(calScore(5000, false, 3));
        System.out.println(calScore(5000, false, 4));
        System.out.println(calScore(5000, false, 5));
    }

    private int calScore(int score, boolean isCorrect, int ctnwrong) {
        int scoreIncrement = 0;
        if (ctnwrong < 5) {
            scoreIncrement = ScoreIncrementEnum.getScoreIncrement(ctnwrong);
        } else {
            scoreIncrement = ScoreIncrementEnum.ZERO.getScoreIncrement();
        }

        if (!isCorrect) {
            scoreIncrement = -scoreIncrement;
        }

        return score + scoreIncrement;
    }
}
