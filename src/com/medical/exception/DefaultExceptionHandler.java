package com.medical.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import com.medical.utils.result.DataResult;

public class DefaultExceptionHandler implements HandlerExceptionResolver {  
	private static Logger log = Logger.getLogger(DefaultExceptionHandler.class);
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();	        
        /*	使用response返回	*/
        response.setStatus(HttpStatus.OK.value()); //设置状态码
        System.out.println("状态吗"+HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            //response.getWriter().write("{\"success\":false,\"msg\":\"" + ex.getMessage() + "\"}");
        	System.out.println("状态吗"+ex.toString());
        	log.error(ex);
        	response.getWriter().write(DataResult.error(ex.getMessage()));
        } catch (IOException e) {
           log.error("与客户端通讯异常:"+ e.getMessage(), e);
        }

        log.debug("异常:" + ex.getMessage(), ex);
        return mv;
}
}
