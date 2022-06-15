package com.liuduck.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author DZHooo
 * @version 1.0
 * @date 2022/6/15 19:02
 * @description: TODO
 */

@ApiModel("排行榜信息")
@Data
public class RankingListVo {

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("答对数量")
    private Integer rightCount;

    @ApiModelProperty("词汇量")
    private Double score;

}
