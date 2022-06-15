package com.liuduck.controller;

import com.liuduck.common.Result;
import com.liuduck.dto.TestDto;
import com.liuduck.service.IWordService;
import com.liuduck.service.TestService;
import com.liuduck.vo.TestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyt
 * @since 2022-06-14
 */
@Api("词汇测试")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IWordService wordService;

    @Autowired
    private TestService testService;

    @PostMapping("/{id}")
    public Result vocabularyEstimate(@PathVariable("id") Integer id, Integer num, Integer option, Integer answer, Integer score) {
        Result result = new Result();
        // 开始测试
        if (num == 0) {
            // 提取一个初中的词汇和释义，还有三个其他单词的释义
            wordService.getById(100);

            // 打乱，并指明正确的选项

        } else {


            // 提取一个初中的词汇和释义，还有三个其他单词的释义
            wordService.getById(100);

            // 打乱，并指明正确的选项

        }

        return result;
    }

    @ApiOperation("进行词汇测试")
    @PostMapping("/estimate")
    public Result<TestVo> estimate(@RequestBody TestDto dto) {
        TestVo testVo = testService.estimate(dto);
        return Result.succ(testVo);
    }
}
