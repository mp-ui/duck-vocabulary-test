package com.liuduck.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuduck.common.Result;
import com.liuduck.entity.User;
import com.liuduck.service.IWordService;
import com.liuduck.utils.RedisConstants;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuduck
 * @since 2022-06-14
 */
@RestController
@CrossOrigin
@RequestMapping("/word")
public class WordController {

    @Autowired
    private IWordService wordService;

    @ApiOperation("分页获取单词, status: 1初中，2高中，3专四，4专八；page：页号，number：数量")
    @PostMapping("/getWords")
    public Result getWords(Integer status, Integer page, Integer number) {
        return Result.succ(wordService.getWords(status, page, number));
    }

}
