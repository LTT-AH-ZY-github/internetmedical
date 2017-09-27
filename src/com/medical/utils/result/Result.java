package com.medical.utils.result;


public class Result implements IResult {

    public int code;
    public String msg;

    public Result() {

    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }

    /**
     * 用于error方法和success方法的
     */
    public static String success(String msg) {
        return new Result(ResultCommon.CODE_SUCCESS, msg).toJson();
    }

    public static String error(String msg) {
        return new Result(ResultCommon.CODE_ERROR, msg).toJson();
    }

    @Override
    public String toJson() {
        return String.format("{\"code\": %d, \"msg\": \"%s\"}", code, msg);
    }

}
