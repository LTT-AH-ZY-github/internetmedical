package com.medical.interceptor;

import java.security.NoSuchAlgorithmException;

/**
 * 对Token进行操作的接口
 * 
 */
public interface TokenManager {

    /**
     * 创建一个token关联上指定用户
     * @param userId 指定用户的id
     * @return 生成的token
     * @throws NoSuchAlgorithmException 
     */
	public  TokenModel createToken(String name,long time) throws NoSuchAlgorithmException ;

    /**
     * 检查token是否有效
     * @param model token
     * @return 是否有效
     */
    public int checkToken(String token);

    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
    public long getTokenTime(String token);
    public long addTokenTime(String token,int day);

    /**
     * 清除token
     * @param token 登录用户的token
     */
    public void deleteToken(String token);

	long setTokenTime(long time, int day);

	

}
