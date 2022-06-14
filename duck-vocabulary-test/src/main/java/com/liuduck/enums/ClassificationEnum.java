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
    /** 专四, 4000-7000 */
    TEM4(3, "专四"),
    /** 专八, 7000-10000 */
    TEM8(4, "专八");

    private final int code;
    private final String name;

    public static String getName(byte code) {
        for (ClassificationEnum c : ClassificationEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }
}
