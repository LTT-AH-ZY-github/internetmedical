package com.pay.alipay;

import java.io.FileWriter;
import java.io.IOException;

import com.medical.utils.Global;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 沙箱版应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	//public static String APP_ID = "2016082700318370";
	//正式版
	public static String APP_ID = "2017112200089517";
	
	// 沙箱版商户私钥，您的PKCS8格式RSA2私钥 
	//public static String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCTTJHZ7XEcsTSbg1p0aCyqluwS9hjnQuf0tY6y6K02D/lLgR19dU3lCFb5dLaGedieYN9Xwg5z5sAZ9dRPVSAoL4EeCPJtPMUY2zbhM54AJq7ABxzljSUjnGYjHaf7UuWGdboiUa3Fm0jhgyDsJ7Z8p/ox+ATXTVV8D9cR0g9ITgHfNa1FoQRSLBdTiIDiM+zn65ty4X8N1KGGOiiLC3/71NTjzo9e1QMgl9Ud17NT33Ozr6/xFUktR6Hppk2CA3L+IOUgHYGNXJgg+ntRPMxbHGIUF/1PH00N7cmaGRSNtBWYHpHlIEg3QT9ASDfatIF6o8PrlN74o6ntvevJ7iGBAgMBAAECggEAC4OpxxJTjD2h8iIjeQQHsdIYZCcOrU1CmpNyszOTDq3S+/780ijQTP4I5nkkJ4Dw2PiTnOWTgaXhEGZyET2DRQDpo/JpGPbuJVJFiPci+7oKYQJtVNhitdTs+wO/dNr3DDq5sSMXZWINIWvBsBQupLHw0eUkY7ws2YTXeBImla08+4JFa08vIHpGomTH8aCcA0sBU8GyjZ9Q4Cl8qebGaFf8Lw0tbrfhEtr3hv+DAGa83aiXbJPoDASRSBteGmoJodzBYLfDSD0hEy7fgmAj/QL8fQAdAoz8tMfYCjjheLYhZSM7ampD0968T8/SPLrEyujKst760vOlfLrr/sL9/QKBgQDMo7K8OOCkf4Io1Ar1xpYYBSQ2u7n8XrQ229UmTEn11gCDzwgMeLXGaM3xcoUOqVpe6cmazlXrQFd645DKV56cnKWEtZYLXkRJhsqHBg8mOgGLa2ihtUmNuS6AGGzNlUhF+ZDS0CXGwwucS0bOs4MKIApAwZQg75XUfrW36s2QYwKBgQC4RLGElZdTmNPZ+f9zTSjrBxtQMHtlVdXiq+AlNIpBry3jSyztV31xQBtSjlZ9sXqS8ecHIq5Ye4YZf3r+DfQZ5W9r74tPNOvEd7XKjkGrRMkC7wOCC5GGRq2OdnvFXeGvxkyOk/hYRXVwqL5Y/CsLO70PpgvZ31rd3CXMjEbBywKBgCeDHAm3ubhJXmpfttYJyAVPSNTAnoKaDpXhEGDarhUnguXwXY965y4uIkWSZRqVnHtjDKg1WuWXgMybj+Nh06BNpq/fF9+ODgVcX1J+2wH4hT/UN1mx1UfmD5JwJOH1BwVr0IjD4+di1aUR69QRWSXlVdV3CxDo8bcb2B5w2cwdAoGBAILlsWDozw3Ag8XVdKSYjFegvcNSHWYX+o9B30EuuIP+iE9tSKX1P5QioQYdPM2fNN6L3rzP4x/R56nXSCyPBvcaZ/M5wDFs+4qeK1KPiZC7lTtzRH+t7ht/u6x2+Gd00GyIJjwmWwWBmfKEvGsD/yPEtQIXx1Vm9+qgh21tvJnPAoGBAKkiXjTn6HGXpsn89PMmRSO3U8djJ4TLYH7sPNhQT3u0A6foaTnRYHduCnoRW/GWj8wjKC9RlQReuQHb8ZeR97jCvV5hW/Yze3WflJ31RzS1P3k6+Ujcy4T0hqQjzOZ9hT82o4eWilmxWWDwRqUitpPPAZcYJmYlTlEMSeYIAfhY";
    //正式版
	public static String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCAGU8yvpneCHUlFTNtT8aKPAnxDqtS/kbotIjtpQUSYbq4zdYqCBPA+OV0aqrZ2EVU6+rJZceab2fjDEVPtPZG1ZT0N03uCvP4qlpBg67tBSKZFTtIVIick5AMd+EuUUtLZuVFLErM7eKm+Xzjt0emzaLNzg3Ga7UAyoA/a/e9Kqj/SNW2N0Q8vy3j2Bs92sTIbxr80u4U1nrg51tLG6A9uAyX2XZXZLOD9ybTp9sQDrjUGxFKsfUU5vtjzBuMvsxP92Iw86Ruk/atKT7+1U/hK+I8MRZPdaJvOItYYDLmzNLZrB7z5cI8VkpH8tUmiQVKlcEyu9N2sAz+r6bf8afJAgMBAAECggEACH0k4XD+E1euI6n3AXxy5MA7zGyzb8mH+23TUSRJZMFzNUH2ukxUusoDsqZK8irB1XHY2kXTZ2mQkdxDT5fnZiRLPa/YizjQmB754jOOyQg5FbnxdsabUvz4Y8sh8gbTHYkREndv8YqmJXiNDS4dInGoI0lPYmHK2eWRgCJwhWmQxF61eW4ulSaqdK0ov19e7j/zYNVYs+cU1cO1sU3wI4YIBd+dnaeqIU7QAdjYaa3uasITb8ucfcsLEj8qmv66EiPrs27DYOl0hw6QCbFC9sxdy3uQqYvS8K+G9vRZTnbm+kcBvGQksCve9z9RP8kQ6Mgy09W+8aAq71ORVUXQHQKBgQDf4lWqIXc5igXpbXKnGcunsjgZoJkeV3LxfS0JLKbsQqLuE3U5poRr3V/rHnNrjkCgmdeb+45GwBJziD/7aw5WmIPLukjL28gRIra87l/TGJD2ER/gc5DOY0vii0/ZNpjcFVW6gNVgr2N3MYGj9nnOAnY6cLtiv4UoHB2bOwinWwKBgQCSeXdVxxwdIODIt0JMFee4XxQSlcXVj4rAN8gHMtBWSg8xRHUB9x9dOfUsdgYl6YdavID8XFcfmcPMVclCuRm7hA01ejxVnab4jMy/eGvIHMJ/t7CXHMOdBTxu42K9nJ7sf/YxUgCyZ7iUEWpEKX93TjAsCfC3A/eFArmeMSH6qwKBgF8YZySdlGO3Ua2F1KZPmaaAV73i7kbqBCO49LEp6zj9UPFpCGjVZvfeDwjyZToxMRhGYEOcBSHeIbg7Dlo/bdawb4LQfG1CzGci5JW5drBWhfRO78hJrh9MJAZ1ABSWUTViRoiygm/P76LIP3WikrhDaW6HRcC68tdHofe2ioVzAoGAXkK60EG9TuV8os6EZLBoGZdeNIOb985TLVX4bOF/fzhTxJHYdrZQwc7tf3pIhJdfWr4ah8zo6FYs0c+XIFA8Rhc55ONP9ozpCeSaUtGtEu+nH0fX5bdGD0NyW64LOhiTkYDbr2ulNSpYdzkp2MmX1PBFQeH3vd9Yp4lUaIAX7NcCgYEAoGOCf/uAhEIc12kUjNNDpJtxbM13WwmSi+Gnier+VdPH3a69Uf6/mwCq/U0QcEqk9NJXF0MxXFFL5XLRF119urfwgMe8xP+H77E8M/LARp3bb8QvLN3Vulw4tWJv5c/tXFHhmIMuu0rjfyl89FdyEEni4sM/qLtEDR5A0YZwiIg=";
	
	// 沙箱版支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	//public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx0KSaUR6lR0zD5YDNN4kov9fzoZ+9RupS3jh7KyJ5nUR8dHSYgHsOaoQ44CVyst/oWAegGMZXjWgaN4ha65smTSaaxKuGSFiVXT68ZCFXqbUL/uSf/82nfLl4525lao37JlW22O2qZLhBXHtvDkFj/NX2IASmkcnI0u6Yvm/XkwckyMICUYfMkdA+mMhEWlWABHnAMkTwbxb9mXgPJLNiPCFSJB1YnUeDZULVa84lzx0OtnmmxsjWZ7/WY2kP5i1fHICGZwK13QZ56djBcGpUQaGOyCjV9ToWdvVdkDTkKKFtgJ9NXXACGsT1xuTPveDBQlvBec1G56np29cko0H6QIDAQAB";
    //正式版
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAszJq0o1JIBVGM40DOG93K0QqEH1kfvCWia7l1skexdZF4toegrXIsbCWyK8qQpdURAe3LZ88zUROXFAb1B+1RKyni/X7EXujVUsv8Z3/EkQuXb166lhoMlTbnjwuuAJE0Vbp3Pi5+ZEFC6w0MPS52ILi+3geVqR3+rq6uersHJ4pbznSvcIGygG7us9+FwQy3/zFxEa0qRkfcDzolM6reJHJaSB1IruRnnjGbQgJGRVOCuxJ7irC1Sz/SMcGerOjQHFqsfr61TPvFg/5EynQumOfZTWv4DTMjgAySWoAZcz8/Mm7GJdFYsSfNaxnZM/Wj1xPCgVFBreA4pONktFDJwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String NOTIFY_URL = "";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String RETURN_URL = Global.DOC_HTTP_URL+"Web_Medical/Main/doctor/PaySuccess.action";

	// 签名方式
	public static String SIGN_TYPE = "RSA2";
	
	// 字符编码格式
	public static String CHARSET = "utf-8";
	
	// 支付宝网关
	//public static String GATEWAYURL = "https://openapi.alipaydev.com/gateway.do";
	//正式
	public static String GATEWAYURL = "https://openapi.alipay.com/gateway.do";
	
	// 支付宝网关
	public static String LOG_PATH = "C:\\";
	
	//病人支付医生回调路径
	public static String DOCTOR_NOTIFY_URL = Global.HTTP_URL+"internetmedical/user/paydoctorfinishbyalipay";
	
	//病人支付医院回调路径
	public static String HSOP_NOTIFY_URL = Global.HTTP_URL+"internetmedical/user/payhospitalfinishbyalipay";
	
	//医院支付医生回调路径
	public static String WEB_HSOP_NOTIFY_URL = Global.HTTP_URL+"internetmedical/hospital/paydoctorfinishbyalipay";
    //↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(LOG_PATH + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

