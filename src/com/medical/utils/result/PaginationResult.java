package com.medical.utils.result;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by WangJiang on 2017/1/21.
 * 带数据的返回结果
 */

public class PaginationResult extends DataResult {

   
    private Object page = null;

    public PaginationResult(int code, String msg, Object data,Object page) {
        super(code,msg,data);
        this.page = page;
    }

//    public Object getData() {
//        return data;
//    }
//
//    public void setData(Object data) {
//        this.data = data;
//    }

    public static String success(String msg, Object data, Object page) {
        return new PaginationResult(ResultCommon.CODE_SUCCESS, msg, data,page).toJson();
    }

    public static String error(String msg, Object data, Object page) {
        return new PaginationResult(ResultCommon.CODE_ERROR, msg, data,page).toJson();
    }

    /**
     * 没有全面测试
     */
    @Override
    public String toJson() {
        return String.format("{\"code\": %d, \"msg\": \"%s\", \"data\": %s, \"page\": %s}", code, msg, new GsonBuilder().serializeNulls().create().toJson(data), new GsonBuilder().serializeNulls().create().toJson(page));
    }

}
