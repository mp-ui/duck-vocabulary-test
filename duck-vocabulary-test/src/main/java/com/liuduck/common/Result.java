package com.liuduck.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author lzk
 * @Email 1801290586@qq.com
 * @Description <类说明>结果统一封装
 * @Date 16:07 2022/6/14
 */
@Data
public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    //    成功
    public static <T> Result<T> succ(T data) {
        return Result.succ(200, "ok", data);
    }

    public static <T> Result succ(int code, String msg, T data) {
        Result<T> r = new Result<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    //    失败
    public static <T> Result fail(String msg) {
        return Result.fail(msg, null);
    }

    public static <T> Result fail(String msg, T data) {
        return Result.fail(400, msg, data);
    }

    public static <T> Result fail(int code, String msg, T data) {
        Result<T> r = new Result<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}
