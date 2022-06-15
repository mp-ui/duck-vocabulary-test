package com.liuduck.controller;

import com.liuduck.common.Result;
import com.liuduck.service.IWordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author DZHooo
 * @version 1.0
 * @date 2022/6/15 18:53
 * @description: TODO
 */

@Api("排行榜")
@RestController
@RequestMapping("/rankingList")
public class RankingListController {

    @Autowired
    private IWordService wordService;

    @ApiOperation("获取排行榜")
    @GetMapping("/getRankingList")
    public Result getRankingList() {
        return Result.succ(wordService.getRankingList());
    }

}
