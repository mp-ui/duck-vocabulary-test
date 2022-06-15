package com.liuduck.service;

import com.liuduck.dto.TestDto;
import com.liuduck.vo.TestVo;

/**
 * @author Prince
 * @since 2022/6/15 13:55
 */
public interface TestService {

    /**
     * 进行词汇测试
     * @param dto 传入Dto对象
     * @return 返回TestVo对象
     */
    TestVo estimate(TestDto dto);

}
