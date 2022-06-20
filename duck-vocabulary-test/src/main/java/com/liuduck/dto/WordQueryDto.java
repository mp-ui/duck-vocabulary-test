package com.liuduck.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Prince
 * @since 2022/6/17 15:00
 */
@Data
@Api("单词查询对象")
public class WordQueryDto {

    @ApiModelProperty("类型，1初中，2高中，3专四，4专八")
    Integer status;

    @ApiModelProperty("页号")
    Integer page;

    @ApiModelProperty("数量")
    Integer number;
}