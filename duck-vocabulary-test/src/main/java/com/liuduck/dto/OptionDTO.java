package com.liuduck.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author wyt
 * @since 2022-06-14
 */

@ApiModel(value = "词汇量测试入参", description = "词汇量测试入参")
@Data
public class OptionDTO {
    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("提交的题号")
    private Integer num;

    @ApiModelProperty("选项")
    private Integer option;

    @ApiModelProperty("正确选项")
    private Integer answer;

    @ApiModelProperty("用户分数")
    private Integer score;

    @ApiModelProperty("总错题数")
    private Integer wrong;

    @ApiModelProperty("当前连续错题数")
    private Integer ctnwrong;
}
