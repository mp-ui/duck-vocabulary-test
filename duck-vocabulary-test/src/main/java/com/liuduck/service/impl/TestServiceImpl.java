package com.liuduck.service.impl;

import com.liuduck.dto.TestDto;
import com.liuduck.service.IWordService;
import com.liuduck.service.TestService;
import com.liuduck.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author Prince
 * @since 2022/6/15 13:56
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private IWordService wordService;

    /**
     * 初中词汇，分数阈值
     */
    private static final int MIDDLE_THRESHOLD = 0;

    /**
     * 高中词汇，分数阈值
     */
    private static final int HIGH_THRESHOLD = 2000;

    /**
     * 专四词汇，分数阈值
     */
    private static final int TEM4_THRESHOLD = 4000;

    /**
     * 专八词汇，分数阈值
     */
    private static final int TEM8_THRESHOLD = 7000;

    /**
     * 一共测试多少个词汇
     */
    private static final int TOTAL_TEST_COUNT = 30;



    @Override
    public TestVo estimate(TestDto dto) {
        if(dto.getNum() >= TOTAL_TEST_COUNT) {
            // 测试结束
            TestVo vo = new TestVo();
            vo.setNum(dto.getNum());
            vo.setIsFinish(true);
            vo.setTotalScore(dto.getTotalScore());
            Random rd = new Random();
            vo.setVocabularyCount(Math.max(10, dto.getTotalScore() + rd.nextInt(500) - 250));
            return vo;
        } else{
            // TODO
        }
        return null;
    }
}
