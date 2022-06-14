package com.liuduck.controller;

import com.liuduck.common.CommonResult;
import com.liuduck.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyt
 * @since 2022-06-14
 */
@RestController("/test")
public class TestController {

    @Autowired
    private IWordService wordService;

    @PostMapping("/{id}")
    public CommonResult vocabularyEstimate(@PathVariable("id") Integer id, Integer num, Integer option, Integer answer, Integer score) {
        CommonResult result = new CommonResult();
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
}
