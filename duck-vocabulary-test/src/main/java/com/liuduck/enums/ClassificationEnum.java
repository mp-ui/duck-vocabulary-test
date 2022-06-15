package com.liuduck.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description
 * @Author wyt
 * @Date: 2022/6/14
 */

@AllArgsConstructor
@Getter
public enum ClassificationEnum {
    /** 初中, 0-2000 */
    MIDDLE(1, "初中"),
    /** 高中, 2000-4000 */
    HIGH(2, "高中"),
    /** 专四, 4000-7500 */
    TEM4(3, "专四"),
    /** 专八, 7500-13000 */
    TEM8(4, "专八");

    private final int code;
    private final String name;

    public static String getName(int code) {
        for (ClassificationEnum c : ClassificationEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

    public static int getStatus(int score) {
        if (score < 2000) {
            return 1;
        } else if (score < 4000) {
            return 2;
        } else if (score < 7500) {
            return 3;
        } else  {
            return 4;
        }
    }
}
