package com.medical.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jdk.nashorn.internal.ir.annotations.Reference;

/**
 * 
 * <p>Title: HandlerInterceptor1</p>
 * <p>Description:测试拦截器1 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-14下午4:45:47
 * @version 1.0
 */
public class HandlerInterceptor1 implements HandlerInterceptor {

	
	//进入 Handler方法之前执行
	//用于身份认证、身份授权
	//比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle( HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String token = request.getHeader("token");
		System.out.println("拦截器token"+token+handler.toString());
		return true;
		/*//获取请求的url
		System.out.println("拦截器"+request.getRequestURI());
		String url = request.getRequestURI();
		//判断url是否是公开 地址（实际使用时将公开 地址配置配置文件中）
		//这里公开地址是登陆提交的地址
		if(url.indexOf("login")>=0||url.indexOf("register")>=0){
			//如果进行登陆提交，放行
			return true;
		}
		//如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String token = request.getHeader("token");
        MapTokenManager mapTokenManager  =new MapTokenManager();
        int result = mapTokenManager.checkToken(token);
        if(result ==3){
        	return true;
        }
        return false;*/
    
	}

	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("HandlerInterceptor2...postHandle");
		
	}

	//执行Handler完成执行此方法
	//应用场景：统一异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("HandlerInterceptor2...afterCompletion");
	}

}
