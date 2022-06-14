package com.liuduck.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@ApiModel(value = "Score对象", description = "")
@Data
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("uid")
    private Integer uid;

    @ApiModelProperty("正确得个数")
    private Integer rightcount;

    @ApiModelProperty("分数")
    private Double score;

    @ApiModelProperty("时间")
    private LocalDateTime time;

}
