package com.liuduck.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuduck
 * @since 2022-06-14
 */
@ApiModel(value = "Score对象", description = "")
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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Integer getRightcount() {
        return rightcount;
    }

    public void setRightcount(Integer rightcount) {
        this.rightcount = rightcount;
    }
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Score{" +
            "uid=" + uid +
            ", rightcount=" + rightcount +
            ", score=" + score +
            ", time=" + time +
        "}";
    }
}
