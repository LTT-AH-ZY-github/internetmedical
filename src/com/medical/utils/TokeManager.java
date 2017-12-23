package com.medical.utils;


import com.alibaba.fastjson.JSON;
import com.medical.po.custom.TokenModel;





public class TokeManager {
	
	public static String createToken(Integer uid ,String phone) throws Exception  {
		TokenModel tokenmodel = new TokenModel();
		tokenmodel.setUid(uid);
		tokenmodel.setPhone(phone);
		tokenmodel.setCreateTime(System.currentTimeMillis());
		String tokenString = JSON.toJSONString(tokenmodel);
		String  desToken = DESUtil.encrypt(tokenString, Global.ENCRYPT_KEY);
		long  expireTime = System.currentTimeMillis()+Global.TOKEN_OUT_TIME;
		Global.globalToken.put(desToken, expireTime);
        return desToken;
    }
	/**
     * token是否可用
     * @Title: isTokenEnable 
     * @Description: TODO
     * @param token
     * @param ip
     * @return
     * @return: boolean
	 * @throws Exception 
     */
    public static boolean isTokenEnable(String token) throws Exception{
        if (Global.globalToken.get(token) == null){
        	return false;
        }
        long expireTime =(Long) Global.globalToken.get(token); 
        if (expireTime > System.currentTimeMillis()){
            return true;
        }
        return false;
    }
    public static long addTokenTime(String token){
    	long  expireTime = System.currentTimeMillis()+Global.TOKEN_OUT_TIME;
		Global.globalToken.put(token, expireTime);
		return expireTime;
	}
    public static void deleteToken(String token) {
    	Global.globalToken.remove(token);
	}
	/*public int checkToken(String token) {
		if(tokenMap.get(token) == null){
			return 1;  // 当前token不存在
		}else{
			long time = new Date().getTime();
			long endTime =(Long) tokenMap.get(token);
			if(time>endTime){
				return 2; // token已过期
			}
		}
		return 3; //验证成功
	}

	
	public long setTokenTime(long time,int day){
		long  expireTime = new Date().getTime()+1000*60*60*24*day; 
		return time+expireTime;
	}
	@Override
	public long addTokenTime(String token,int day){
		long  expireTime = new Date().getTime()+1000*60*60*24*day; 
		//long  time =(Long) tokenMap.get(token);
		tokenMap.put(token, expireTime);
		return expireTime;
	}

	@Override
	public void deleteToken(String token) {
		tokenMap.remove(token);	
		
	}

	@Override
	public long getTokenTime(String token) {
		
		return 0;
	}*/
}
