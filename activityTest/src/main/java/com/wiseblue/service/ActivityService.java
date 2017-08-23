package com.wiseblue.service;

import com.wiseblue.bean.Activity;
import com.wiseblue.dao.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityMapper activityMapper;


    /**
     * 获取全部活动
     * @return
     */

    public List<Activity> getAll(){

        return activityMapper.selectByExample(null);
    }


    /**
     * 储存活动
     * @param activity
     */

    public void saveActivity(Activity activity){
        activityMapper.insertSelective(activity);
    }


    /**
     * 获取单个活动
     * @param activityId
     * @return
     */
    public Activity getActivity(Integer activityId){
        Activity activity=activityMapper.selectByPrimaryKey(activityId);
        return activity;
    }


    /**
     * 更新活动
     * @param activity
     */

    public void updateActivity(Activity activity){
        activityMapper.updateByPrimaryKeySelective(activity);
    }

    /**
     * 删除活动
     * @param activityId
     */
    public void deleteActivity(Integer activityId){
        activityMapper.deleteByPrimaryKey(activityId);
    }


}
