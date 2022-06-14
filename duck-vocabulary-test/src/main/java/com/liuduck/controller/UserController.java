package com.liuduck.controller;

import com.liuduck.common.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzk
 * @since 2022-06-14
 */
@RestController("/user")
public class UserController {

    @Autowired
    JavaMailSenderImpl mailSender;

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Result login(@Param("userName") String userName, @Param("password") String password){
        return Result.succ(null);
    }

    /**
     * 注册
     * @param userName
     * @param password
     * @param nickName
     * @param code
     * @param s
     * @return
     */
    @RequestMapping("/register")
    public Result register(@Param("userName") String userName, @Param("password") String password,
                           @Param("nickName") String nickName, @Param("code") String code, HttpSession s){
        return Result.succ(null);
    }

    /**
     * 获得验证码
     * @param s
     * @return
     */
    @RequestMapping("/getCode")
    public Result getCode(@Param("email") String email,HttpSession s){
        //生成验证码
        String str="qwertyuiopasdfghjklzxcvbnmABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb=new StringBuilder(4);
        for(int i=0;i<4;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        s.setAttribute("code",sb.toString());

        //向用户邮箱发送验证码
        SimpleMailMessage mailMessage=new SimpleMailMessage();

        mailMessage.setSubject("【608英语词汇测试】");
        mailMessage.setText("欢迎您的注册,验证码:"+sb+"。请勿转发给他人，若是不是本人注册，不理会即可！");
        //发送的对象
        mailMessage.setTo(email);
        //发件人
        mailMessage.setFrom("204967882@qq.com");
        //发送
        mailSender.send(mailMessage);
        return Result.succ(null);
    }
}
