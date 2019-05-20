package com.medical.interceptor;




import org.springframework.stereotype.Component;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过Redis存储和验证token的实现类
 * @see com.scienjus.authorization.manager.TokenManager
 * @author ScienJus
 * @date 2015/7/31.
 */
@Component
public class MapTokenManager implements TokenManager {
	public static Map<String , Object> tokenMap=new HashMap<String, Object>();
	@Override
	public TokenModel createToken(String name,long time) throws NoSuchAlgorithmException {
        TokenModel tokenmodel = new TokenModel(name, time);
        tokenMap.put(tokenmodel.getToken(), tokenmodel.getTime());
        return tokenmodel;
    }

	@Override
	public int checkToken(String token) {
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

	@Override
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
	}

	

    /*public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        long userId = Long.parseLong(param[0]);
        String token = param[1];
        return new TokenModel(userId, token);
    }

    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String token = redis.boundValueOps(model.getUserId()).get();
        if (token == null || !token.equals(model.getToken())) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redis.boundValueOps(model.getUserId()).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return true;
    }

    public void deleteToken(long userId) {
        redis.delete(userId);
    }*/
}
