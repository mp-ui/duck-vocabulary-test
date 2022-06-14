package com.liuduck.service.impl;

import com.liuduck.entity.User;
import com.liuduck.mapper.UserMapper;
import com.liuduck.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuduck
 * @since 2022-06-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
