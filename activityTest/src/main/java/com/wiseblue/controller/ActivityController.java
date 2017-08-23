package com.wiseblue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.wiseblue.bean.Activity;
import com.wiseblue.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ActivityController {
    @Autowired
    ActivityService activityService;


    /**
     * 删除全部活动
     * @param activityId
     * @return
     */

    @RequestMapping("/delete")
    @ResponseBody
    public Map deleteActivity(Integer activityId){
        activityService.deleteActivity(activityId);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("success","success");
        return map;
    }


    /**
     * 更新活动
     * @param
     * @return
     */


    @RequestMapping("/update")
    @ResponseBody
    public String updateActivity(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String line=null;
        InputStream inputStream=request.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb=new StringBuilder();
        while ((line=reader.readLine())!=null){
            sb.append(line);
        }
        Gson gson=new Gson();
        Activity activity=gson.fromJson(sb.toString(),Activity.class);
        activityService.updateActivity(activity);
        return "success";
    }


    /**
     * 查询单个活动
     * @param activityId
     * @return
     */


    @RequestMapping("/query")
    @ResponseBody
    public Map queryActivity(Integer activityId){
        Activity activity=activityService.getActivity(activityId);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("activity",activity);
        return map;
    }


    /**
     * 新增活动
     * @return
     */


    @RequestMapping("/save")
    @ResponseBody
    public String saveActivity(HttpServletRequest request)throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        String line=null;
        InputStream inputStream=request.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb=new StringBuilder();
        while ((line=reader.readLine())!=null){
            sb.append(line);
        }
        Gson gson=new Gson();
        Activity activity=gson.fromJson(sb.toString(),Activity.class);
        System.out.println(activity);
            activityService.saveActivity(activity);
            return "success";

    }

    /**
     * 获取全部活动
     * @param page
     * @return
     */


    @RequestMapping("/activities")
    @ResponseBody
    public Map getActivity(@RequestParam(value = "page",defaultValue = "1")Integer page){

        PageHelper.startPage(page,10);

        List<Activity> activities=activityService.getAll();

        PageInfo pageInfo=new PageInfo(activities,1);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("pageInfo",pageInfo);
        return map;
    }
}
