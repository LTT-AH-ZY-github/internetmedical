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
 * @ClassName:     QiniuUtil.java
 * @Description:   七牛云上传图片
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月7日 下午9:49:07 
 */
public class QiniuUtil {

    
	public static final String BASE_URL = "http://oytv6cmyw.bkt.clouddn.com/";

    public static String upload(String filePath) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());    //zone2华南机房
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        
        //...生成上传凭证，然后准备上传
        String accessKey ="kmZ0QMNGp3xeycMaQE8TbQmxVWnlDcgulHVmdP-V";
        String secretKey = "N_XeO4QMJuPnC6uvA4DoSHRlXTp6mBcTn0rI069Q";
       
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
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            return BASE_URL+putRet.key;
           
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
