package com.liuduck.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuduck
 * @since 2022-06-14
 */
@ApiModel(value = "Word对象", description = "")
@Data
public class Word implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("wid")
    @TableId(value = "wid", type = IdType.AUTO)
    private Integer wid;

    @ApiModelProperty("单词")
    private String word;

    @ApiModelProperty("分类")
    private Integer status;

    @ApiModelProperty("词意")
    private String mean;

}
