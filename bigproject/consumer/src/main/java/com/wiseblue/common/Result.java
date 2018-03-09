package com.wiseblue.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiZhikang on 2018/2/8.
 */
public class Result {

    private int code;

    private String msg;

    private Map<String,Object> info=new HashMap<>();

    public static Result success(){
        Result result=new Result();
        result.setCode(200);
        result.setMsg("处理成功");
        return result;
    }

    public static Result fail(){
        Result result=new Result();
        result.setCode(404);
        result.setMsg("处理失败");
        return result;
    }

    public Result add(String key,Object value){
        this.getInfo().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }
}
