package com.liuduck.utils;

/**
 * @Author lzk
 * @Email 1801290586@qq.com
 * @Description <类说明>redis缓存中的的key的前缀
 * @Date 20:21 2022/6/14
 */
public class RedisConstants {
    public static final String LOGIN_CODE_KEY = "register:code:";
    public static final Long LOGIN_CODE_TTL = 10L;
    public static final String LOGIN_USER_KEY = "login:token:";
    public static final Long LOGIN_USER_TTL = 30L;
}
