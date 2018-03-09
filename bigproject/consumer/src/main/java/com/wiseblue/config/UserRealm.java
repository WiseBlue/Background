package com.wiseblue.config;

import com.wiseblue.bean.User;
import com.wiseblue.bean.UserExample;
import com.wiseblue.service.UserService;
import com.wiseblue.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by LiZhikang on 2018/2/25.
 */
public class UserRealm extends AuthorizingRealm {

    private static final Logger logger=LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private UserService userService;
    //private UserService userService= (UserService) ShiroSpring.getBean("userService");

    private Integer userId;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info=null;
        String userName=String.valueOf(principalCollection.getPrimaryPrincipal());
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        List<User> users = userService.getUser(userExample);
        Integer j = 0;
        for (User i : users) {
            userId = i.getUserId();
            j++;
        }
        if (j >= 2) {
            throw new AuthorizationException();
        }
        User user = userService.getUser(userId);
        if (user == null) {
            throw new AuthorizationException();
        }
        String authority=user.getUserAuthority();
        Set<String> authorities=new HashSet<>();
        authorities.add(authority);
        info=new SimpleAuthorizationInfo(authorities);
        return info;
    }

    /**
     * 用户登录认证
     * 成功登陆过一次之后，shiro会将成功状态进行缓存，如果不注销，shiro会默认一直保持成功状态
     * 进行密码比对，shiro帮我们完成，用户输入的内容UserPasswordToken
     * 对比的操作doCredentialsMatch(token,info)
     * @param authenticationToken
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        SimpleAuthenticationInfo info=null;
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String userName=token.getPrincipal().toString();
        String MD5passowrd=new String((char[]) token.getCredentials());
        MD5passowrd= MD5Util.generatePassword(MD5passowrd);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        List<User> users = userService.getUser(userExample);
        Integer j = 0;
        for (User i : users) {
            userId = i.getUserId();
            j++;
        }
        if (j >= 2) {
            throw new AuthenticationException();
        }
        User user = userService.getUser(userId);
        if (user == null) {
            throw new AuthenticationException();
        }
        SecurityUtils.getSubject().getSession().setAttribute("id", user.getUserId());
        String password=user.getUserPassword();
        info=new SimpleAuthenticationInfo(userName, password, getName());
        return info;
    }
}
