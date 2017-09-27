package com.medical.utils.result;

/**
 * Created by WangJiang on 2016/8/9.
 * 一些常量
 * 话说这个时间这么写的是16年，应该是从EasyHabit那里复制来的代码，整整一年了都(现在是2017/08/10)
 */
public class ResultCommon {

    public final static int CODE_SUCCESS = 100;
    public final static int CODE_ERROR = 200;

    /**
     * 超级长的错误码
     * 密码错误
     */
    public final static int CODE_ERROR_LOGIN_WRONG_PASSWORD = 201;
    /**
     * 账号没有认证
     */
    public final static int CODE_ERROR_LOGIN_NOT_VERIFIED = 202;

    public final static String DESCRIPTION_SUCCESS = "操作成功";
    public final static String DESCRIPTION_ERROR = "操作出错";

}
