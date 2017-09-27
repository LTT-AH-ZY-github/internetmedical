package com.medical.interceptor;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Token的Model类，可以增加字段提高安全性，例如时间戳、url签名
 * @author ScienJus
 * @date 2015/7/31.
 */
public class TokenModel {

    //用户id
    private String name;
    //设备mac
    private long loginTime;
    // 
    private long Time;
    
    private String Token;
    
    public TokenModel(){
    	
    }
    public TokenModel(String name,long Time) throws NoSuchAlgorithmException{
    	this.name=name;
    	this.loginTime=new Date().getTime();
    	this.Time=Time;
    	MessageDigest md = MessageDigest.getInstance("MD5");
        // 计算md5函数
    	String token = this.name+this.loginTime;
        md.update(token.getBytes());
        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        this.Token = new BigInteger(1, md.digest()).toString(16);
    	//...
    }

	public long getTime() {
		return Time;
	}

	public void setTime(long time) {
		Time = time;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}
    
    
    
}
