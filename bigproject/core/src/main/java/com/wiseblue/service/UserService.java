package com.wiseblue.service;

import com.wiseblue.bean.User;
import com.wiseblue.bean.UserExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LiZhikang on 2018/2/8.
 */
public interface UserService {
    List<User> getUsers();
    List<User> getUser(UserExample userExample);
    User getUser(Integer userId);
}
