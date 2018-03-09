package com.wiseblue.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wiseblue.bean.User;
import com.wiseblue.common.Result;
import com.wiseblue.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.apache.shiro.subject.Subject;
import java.util.List;

/**
 * Created by LiZhikang on 2018/2/8.
 * @RestController=@Controller+@ResponceBody
 * 默认返回Json字符串
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final org.slf4j.Logger logger= LoggerFactory.getLogger(UserController.class);

    @Reference
    private UserService userService;

    /**
     * 返回所有用户信息
     */
    @GetMapping("/all")
    public Result getAllUser(){
        List<User> list=userService.getUsers();
        if (list!=null){
            return Result.success().add("users",list);
        }else {
            return Result.fail();
        }
    }

    /**
     *在@RestController下返回页面需要使用ModelAndView
     * 用户登录验证
     */
    /*@PostMapping("/findOne")
    public ModelAndView getOneUser(@RequestParam String userName, @RequestParam String userPassword){
        if (userName.equals("admin")&&userPassword.equals("admin")){
            ModelAndView mv=new ModelAndView("user");
            return mv;
        }else {
            ModelAndView mv=new ModelAndView("bookshop");
            return mv;
        }
    }*/

    @PostMapping("/findOne")
    public ModelAndView getOneUser(@RequestParam String userName, @RequestParam String userPassword){
        Subject currentUser= SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token=new UsernamePasswordToken(userName,userPassword);
            token.setRememberMe(false);
            currentUser.login(token);
        }

        if (currentUser.hasRole("admin")){
            ModelAndView mv=new ModelAndView("user");
            return mv;
        }else if (currentUser.hasRole("user")){
            ModelAndView mv=new ModelAndView("bookshop");
            return mv;
        }else {
            ModelAndView mv=new ModelAndView("error");
            return mv;
        }

    }

    @GetMapping("/logout")
    public ModelAndView logout(){
        Subject currentUser=SecurityUtils.getSubject();
        currentUser.logout();
        if (!currentUser.isAuthenticated()){
            ModelAndView mv=new ModelAndView("logout");
            return mv;
        }else {
            ModelAndView mv=new ModelAndView("error");
            return mv;
        }

    }
}
