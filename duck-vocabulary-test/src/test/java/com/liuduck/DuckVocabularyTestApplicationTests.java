package com.liuduck;

import com.liuduck.util.JsonConvertUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

@SpringBootTest
class DuckVocabularyTestApplicationTests {

    @Autowired
    private JsonConvertUtil jsonConvertUtil;

    @Test
    void contextLoads() {
        jsonConvertUtil.wordsToDataBase();
    }

}
