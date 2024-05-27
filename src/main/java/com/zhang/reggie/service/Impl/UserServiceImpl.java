package com.zhang.reggie.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.reggie.entity.User;
import com.zhang.reggie.mapper.UserMapper;
import com.zhang.reggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author ZhangLi
 * @version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
