package com.medical.utils.result;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by WangJiang on 2017/1/21.
 * 带数据的返回结果
 */

public class DataResult extends Result {

    public Object data = null;

    public DataResult(int code, String msg, Object data) {
        super(code, msg);
        this.data = data;
    }

//    public Object getData() {
//        return data;
//    }
//
//    public void setData(Object data) {
//        this.data = data;
//    }

    public static String success(String msg, Object data) {
        return new DataResult(ResultCommon.CODE_SUCCESS, msg, data).toJson();
    }

    public static String error(String msg, Object data) {
        return new DataResult(ResultCommon.CODE_ERROR, msg, data).toJson();
    }

    /**
     * 没有全面测试
     */
    @Override
    public String toJson() {
        return String.format("{\"code\": %d, \"msg\": \"%s\", \"data\": %s}", code, msg, new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(data));
    }

}
