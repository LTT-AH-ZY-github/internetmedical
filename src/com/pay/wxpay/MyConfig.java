package com.pay.wxpay;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.github.wxpay.sdk.WXPayConfig;

import sun.applet.AppletSecurityException;


/**
 * @ClassName:     MyScanConfig.java
 * @Description:   扫码支付配置 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月27日 上午10:20:34 
 */
public class MyConfig implements WXPayConfig {

	private byte[] certData;
    private static MyConfig INSTANCE;

    private MyConfig() throws Exception{
        String certPath = "C://CERT/common/apiclient_cert.p12";
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

//	@Override
//	public String getAppID() {
//		// TODO Auto-generated method stub
//		//return "wxab8acb865bb1637e";
//		return "wx63bb9550ac7706fe";
//	}
//
//	@Override
//	public String getMchID() {
//		// TODO Auto-generated method stub
//		//return "11473623";
//		return "1227594802";
//	}
//
//	
//	@Override
//	public String getKey() {
//		// TODO Auto-generated method stub
//		return "f421606372cd9df6fbd01a34fc1076b2";
//		//return "2ab9071b06b9f739b950ddb41db2690d";
//	}
   //AppSecret c2971566cbc166f8f108422f5c76d585
    @Override
	public String getAppID() {
		// TODO Auto-generated method stub
		//return "wxab8acb865bb1637e";
		return "wxd97a67a007393b4e";
	}

	
	@Override
	public String getMchID() {
		// TODO Auto-generated method stub
		//return "11473623";
		return "1497265642";
	}

	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "q7uv1349nx0da2pto9cmo8gku3zs6nx9";
		//return "2ab9071b06b9f739b950ddb41db2690d";
	}
	
	@Override
	public InputStream getCertStream() {
		// TODO Auto-generated method stub
		ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(this.certData);
        return certBis;
	}

	
	@Override
	public int getHttpConnectTimeoutMs() {
		// TODO Auto-generated method stub
		return 2000;
	}

	 
	@Override
	public int getHttpReadTimeoutMs() {
		// TODO Auto-generated method stub
		return 10000;
	}

}
