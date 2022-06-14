package com.liuduck;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
class DuckVocabularyTestApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("test",1);
        System.out.println(redisTemplate.opsForValue().get("test"));
    }

}
