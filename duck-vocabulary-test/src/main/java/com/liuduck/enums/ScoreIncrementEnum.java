package com.liuduck.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ScoreIncrementEnum {
    ZERO(0, 1000),
    ONE(1, 800),
    TWO(2, 600),
    THREE(3, 400),
    FOUR(4, 200);

    private final int ctnwrong;
    private final int scoreIncrement;

    public static int getScoreIncrement(int ctnwrong) {
        for (ScoreIncrementEnum c : ScoreIncrementEnum.values()) {
            if (c.getCtnwrong() == ctnwrong) {
                return c.scoreIncrement;
            }
        }
        return -1;
    }
}
