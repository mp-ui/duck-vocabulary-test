package com.liuduck.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "词汇量测试提供的选项", description = "词汇量测试提供的选项")
@Data
public class OptionVO {
    @ApiModelProperty("单词")
    private String word;

    @ApiModelProperty("正确选项")
    private Integer answerPos;

    @ApiModelProperty("正确答案")
    private String answer;

    @ApiModelProperty("干扰项1")
    private String option1;

    @ApiModelProperty("干扰项2")
    private String option2;

    @ApiModelProperty("干扰项3")
    private String option3;

    @ApiModelProperty("用户分数")
    private Integer score;

    @ApiModelProperty("总错题数")
    private Integer wrong;

    @ApiModelProperty("当前连续错题数")
    private Integer ctnwrong;
}
