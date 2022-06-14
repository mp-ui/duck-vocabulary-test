package com.liuduck;

import com.liuduck.util.JsonConvertUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

@SpringBootTest
class DuckVocabularyTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void func() {
        JsonConvertUtil.func();
    }

}
