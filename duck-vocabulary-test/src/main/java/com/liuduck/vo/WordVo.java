package com.liuduck.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author DZHooo
 * @version 1.0
 * @date 2022/6/15 19:46
 * @description: TODO
 */

@ApiModel("单词")
@Data
public class WordVo {

    @ApiModelProperty
    private String word;

    @ApiModelProperty
    private String mean;

}
