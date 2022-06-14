package com.liuduck.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuduck.common.Result;
import com.liuduck.entity.User;
import com.liuduck.utils.RedisConstants;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
@RestController("/word")
public class WordController {
}
