package com.medical.utils;



import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * Created by WangJiang on 2017/6/19.
 */
public class QiniuUtil {

    //public static final String BASE_URL = "http://ors5es4lx.bkt.clouddn.com/";
	public static final String BASE_URL = "http://oytv6cmyw.bkt.clouddn.com/";

    public static String upload(String filePath) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());    //zone2华南机房
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        /*String accessKey = "s009bUduJXE-fLPyJqS6ZbjvEN_ZIUE1e-r_-_eu";
        String secretKey = "yMbunK6yGxIyHN7YvO5Wy7l4AIbZhB2TtWbQQsvt";*/
        String accessKey ="kmZ0QMNGp3xeycMaQE8TbQmxVWnlDcgulHVmdP-V";
        String secretKey = "N_XeO4QMJuPnC6uvA4DoSHRlXTp6mBcTn0rI069Q";
        //String bucket = "light-blog";
        String bucket = "xiongyanghui";
        //如果是Windows情况下，格式是 D:\\qiniu\\test.png
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = FileUtil.getFileName(filePath);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(filePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return BASE_URL+putRet.key;
           //System.out.println(putRet.key);
          // System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }

}
