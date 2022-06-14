package com.liuduck.utils;

import com.liuduck.entity.User;

/**
 * @Author lzk
 * @Email 1801290586@qq.com
 * @Description <类说明>保存登录的类到ThreadLocal中
 * @Date 20:13 2022/6/14
 */
public class UserHolder {
    private static final ThreadLocal<User> tl = new ThreadLocal<>();

    public static void saveUser(User user){
        tl.set(user);
    }

    public static User getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }
}
