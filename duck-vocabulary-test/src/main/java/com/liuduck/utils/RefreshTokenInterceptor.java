package com.liuduck.utils;

import com.liuduck.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @Author lzk
 * @Email 1801290586@qq.com
 * @Description <类说明>拦截查看是否登录过，登录过就直接更新token的时间
 * @Date 20:17 2022/6/14
 */
public class RefreshTokenInterceptor implements HandlerInterceptor {
    private RedisTemplate<String, Object> redisTemplate;

    public RefreshTokenInterceptor(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("authorization");

        //查看浏览器中是否存在authorization
        if (token==null){
            //未登录过，直接放行
            return true;
        }

        //token不为空,直接更新时间
        User user= (User)redisTemplate.opsForValue().get(RedisConstants.LOGIN_USER_KEY + token);
        if (user==null){
            return true;
        }
        //保存信息到ThreadLocal
        UserHolder.saveUser(user);
        //刷新过期时间
        redisTemplate.expire(RedisConstants.LOGIN_USER_KEY + token,RedisConstants.LOGIN_USER_TTL, TimeUnit.MINUTES);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}

