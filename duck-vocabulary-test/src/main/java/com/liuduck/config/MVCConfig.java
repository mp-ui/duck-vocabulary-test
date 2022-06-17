package com.liuduck.config;

import com.liuduck.utils.LoginInterceptor;
import com.liuduck.utils.RefreshTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author lzk
 * @Email 1801290586@qq.com
 * @Description <类说明>MVC扩展
 * @Date 20:08 2022/6/14
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    //添加拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        //token刷新
        registry.addInterceptor(new RefreshTokenInterceptor(redisTemplate)).addPathPatterns("/**").order(0);
        //登录拦截
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/test/**")
                //放行的路径
                .excludePathPatterns(
                        "/user/getCode",
                        "/user/login",
                        "/user/register"
                ).order(1);
    }

}
