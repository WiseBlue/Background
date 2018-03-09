package com.wiseblue.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wiseblue.bean.User;
import com.wiseblue.bean.UserExample;
import com.wiseblue.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by LiZhikang on 2018/2/8.
 */
@Service
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        List<User> users= userMapper.selectByExample(null);
        return users;
    }


    @Override
    public List<User> getUser(UserExample userExample) {
        List<User> users=userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public User getUser(Integer userId) {
        User user=userMapper.selectByPrimaryKey(userId);
        return user;
    }

}
