package com.liuduck.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Prince
 * @since 2022/6/15 13:40
 */
@ApiModel("测试时提交的对象")
@Data
public class TestDto {

    @ApiModelProperty("第几轮")
    Integer num;

    @ApiModelProperty("当前分数")
    Integer totalScore;

    @ApiModelProperty("回答正确的次数")
    Integer correctCount;

}
