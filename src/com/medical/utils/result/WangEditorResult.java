package com.medical.utils.result;

/**
 * Created by WangJiang on 2017/8/8.
 * wangEditor本身是支持多文件上传的，我觉得这个功能没有必要，所以前端设计只能上传单个文件
 */
public class WangEditorResult implements IResult {

    private static final int CODE_SUCCESS = 0;
    private static final int CODE_ERROR = 1;

    private int errno;
    private String[] data;

    private WangEditorResult(int errno, String[] data) {
        this.errno = errno;
        this.data = data;
    }

    public static String success(String url) {
        return new WangEditorResult(CODE_SUCCESS, new String[]{url}).toJson();
    }

    public static String error() {
        return new WangEditorResult(CODE_ERROR, null).toJson();
    }

    @Override
    public String toJson() {
        if (data == null || data.length == 0) {
            return String.format("{\"errno\": %d,\"data\": []}", errno);
        }
        return String.format("{\"errno\": %d,\"data\": [\"%s\"]}", errno, data[0]);
    }

    //Javabean的代码

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

}
