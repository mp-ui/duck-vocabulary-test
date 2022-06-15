package com.liuduck.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Prince
 * @since 2022/6/15 13:43
 */
@ApiModel("返回的信息")
@Data
public class TestVo {

    @ApiModelProperty("第几轮")
    private Integer num;

    @ApiModelProperty("是否结束")
    private Boolean isFinish;

    @ApiModelProperty("当前分数")
    private Integer totalScore;

    @ApiModelProperty("最终估计出的英语词汇量，当isFinish=true时表示测试结束，然后展示词汇量")
    private Integer vocabularyCount;

    @ApiModelProperty("现在测试的英语词汇")
    private String english;

    @ApiModelProperty("四个选项")
    private List<String> options;

    @ApiModelProperty("正确选项")
    private Integer correct;

    @ApiModelProperty("这道题答对获得分数")
    private Integer winScore;

    @ApiModelProperty("这道题答错扣掉分数")
    private Integer failScore;

}
