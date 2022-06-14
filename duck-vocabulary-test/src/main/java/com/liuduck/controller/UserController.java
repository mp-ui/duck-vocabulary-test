package com.liuduck.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuduck.common.Result;
import com.liuduck.entity.User;
import com.liuduck.service.IUserService;
import com.liuduck.utils.RedisConstants;
import com.liuduck.utils.UserHolder;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzk
 * @since 2022-06-14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    JavaMailSenderImpl mailSender;

    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Result login(@Param("email") String email, @Param("password") String password){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        User user = userService.getOne(wrapper);
        if(user==null){
            //不存在该用户
            return Result.fail("该邮箱并未注册");
        }
        //生成token
        String token = UUID.randomUUID().toString();
        token = RedisConstants.LOGIN_USER_KEY+token.replace("-", "");
        //存进redis
        redisTemplate.opsForValue().set(RedisConstants.LOGIN_USER_KEY+token,user,RedisConstants.LOGIN_USER_TTL, TimeUnit.MINUTES);
        //返回token回前端
        return Result.succ(token);
    }

    @RequestMapping("/logout")
    public Result logout(HttpServletRequest request){
        String token = request.getHeader("authorization");
        //删除redis的token
        redisTemplate.delete(RedisConstants.LOGIN_USER_KEY+token);
        //删除Threadlocal的User
        UserHolder.removeUser();
        return Result.succ(null);
    }

    /**
     * 注册
     * @param email
     * @param password
     * @param gender
     * @param nickName
     * @param code
     * @param s
     * @return
     */
    @RequestMapping("/register")
    public Result register(@Param("email") String email, @Param("password") String password,
        @Param("gender") int gender,@Param("nickName") String nickName, @Param("code") String code, HttpSession s){
        String session_code = (String)s.getAttribute("code");
        if(session_code ==null)return Result.fail("还没有获取验证码~");
        if(!code.equalsIgnoreCase(session_code)) {
            //验证码错误
            return Result.fail("验证码输入错误！");
        }
        //邮箱已被注册
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        User obj = userService.getOne(wrapper);
        if(obj!=null) {
            return Result.fail("该邮箱已被注册！");
        }
        //存储到数据库
        User user =new User().setAvatar("https://s1.ax1x.com/2022/06/14/XIBgmj.png")
                .setEmail(email).setGender(gender).setNickname(nickName).setPassword(password).setUid(null);
        userService.save(user);

        //注册成功
        return Result.succ(user);
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
