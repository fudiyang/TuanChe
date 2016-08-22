package com.bwf.tuanche.entiy.qichexiangqing;

/**
 * Created by admin on 2016/8/16.
 */
public class Root {
    private int code;

    private String msg;

    private Result result;

    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setResult(Result result){
        this.result = result;
    }
    public Result getResult(){
        return this.result;
    }
}
