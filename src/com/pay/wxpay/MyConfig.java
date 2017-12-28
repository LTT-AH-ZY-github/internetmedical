/**  
* @Title: MyConfig.java  
* @Package com.pay.wxpay  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月27日  
* @version V1.0  
*/  
package com.pay.wxpay;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.github.wxpay.sdk.WXPayConfig;


/**
 * @ClassName:     MyConfig.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月27日 上午10:20:34 
 */
public class MyConfig implements WXPayConfig {

	private byte[] certData;
    private static MyConfig INSTANCE;

    private MyConfig() throws Exception{
        String certPath = "D://CERT/common/apiclient_cert.p12";
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    public static MyConfig getInstance() throws Exception{
        if (INSTANCE == null) {
            synchronized (MyConfig.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MyConfig();
                }
            }
        }
        return INSTANCE;
    }

	/* (非 Javadoc)  
	* <p>Title: getAppID</p>  
	* <p>Description: </p>  
	* @return  
	* @see com.github.wxpay.sdk.WXPayConfig#getAppID()  
	*/
	@Override
	public String getAppID() {
		// TODO Auto-generated method stub
		return "wxab8acb865bb1637e";
	}

	/* (非 Javadoc)  
	* <p>Title: getMchID</p>  
	* <p>Description: </p>  
	* @return  
	* @see com.github.wxpay.sdk.WXPayConfig#getMchID()  
	*/
	@Override
	public String getMchID() {
		// TODO Auto-generated method stub
		return "11473623";
	}

	/* (非 Javadoc)  
	* <p>Title: getKey</p>  
	* <p>Description: </p>  
	* @return  
	* @see com.github.wxpay.sdk.WXPayConfig#getKey()  
	*/
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "2ab9071b06b9f739b950ddb41db2690d";
	}

	/* (非 Javadoc)  
	* <p>Title: getCertStream</p>  
	* <p>Description: </p>  
	* @return  
	* @see com.github.wxpay.sdk.WXPayConfig#getCertStream()  
	*/
	@Override
	public InputStream getCertStream() {
		// TODO Auto-generated method stub
		ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(this.certData);
        return certBis;
	}

	/* (非 Javadoc)  
	* <p>Title: getHttpConnectTimeoutMs</p>  
	* <p>Description: </p>  
	* @return  
	* @see com.github.wxpay.sdk.WXPayConfig#getHttpConnectTimeoutMs()  
	*/
	@Override
	public int getHttpConnectTimeoutMs() {
		// TODO Auto-generated method stub
		return 2000;
	}

	/* (非 Javadoc)  
	* <p>Title: getHttpReadTimeoutMs</p>  
	* <p>Description: </p>  
	* @return  
	* @see com.github.wxpay.sdk.WXPayConfig#getHttpReadTimeoutMs()  
	*/
	@Override
	public int getHttpReadTimeoutMs() {
		// TODO Auto-generated method stub
		return 10000;
	}

}
