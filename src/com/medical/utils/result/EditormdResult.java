package com.medical.utils.result;

/**
 * Created by WangJiang on 2017/8/10.
 * editor.md的图片上传返回的结果
 */
public class EditormdResult implements IResult {

    private static final int CODE_ERROR = 0;
    private static final int CODE_SUCCESS = 1;

    private int success;
    private String message;
    private String url;

    private EditormdResult(int success, String message, String url) {
        this.success = success;
        this.message = message;
        this.url = url;
    }

    private EditormdResult(int success, String message) {
        this.success = success;
        this.message = message;
    }

    /**
     * 该方法被弃用
     * @see #success(String msg, String url)
     */
    @Deprecated
    public static String success(String msg) {
        throw new RuntimeException("被弃用的方法");
    }

    public static String success(String msg, String url) {
        return new EditormdResult(CODE_SUCCESS, msg, url).toJson();
    }

    public static String error(String msg) {
        return new EditormdResult(CODE_ERROR, msg).toJson();
    }

    @Override
    public String toJson() {
        return String.format("{\"success\":%d, \"message\":\"%s\", \"url\":\"%s\"}", success, message, url);
    }
}
