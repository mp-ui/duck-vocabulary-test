package com.liuduck.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
@ApiModel(value = "Word对象", description = "")
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

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    @Override
    public String toString() {
        return "Word{" +
            "wid=" + wid +
            ", word=" + word +
            ", status=" + status +
            ", mean=" + mean +
        "}";
    }
}
