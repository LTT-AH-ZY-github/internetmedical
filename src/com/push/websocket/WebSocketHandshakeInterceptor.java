package com.push.websocket;
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.http.server.ServerHttpRequest;  
import org.springframework.http.server.ServerHttpResponse;  
import org.springframework.http.server.ServletServerHttpRequest;  
import org.springframework.web.socket.WebSocketHandler;  
import org.springframework.web.socket.server.HandshakeInterceptor;  
  
import javax.servlet.http.HttpSession;  
import java.util.Map;  
  
/** 
 * WebSocket握手拦截器 
 */  
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {  
    private final static Logger LOGGER = LoggerFactory.getLogger(WebSocketHandshakeInterceptor.class);  
  
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {  
        if (request instanceof ServletServerHttpRequest) {  
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;  
            String path = servletRequest.getServletRequest().getRequestURI();
            String userId = "";
            if (path.split("/").length == 5)
            {
            	userId = path.split("/")[4];
            }
            if (userId == null) {  
            	userId = "system-1";  
            }  
            attributes.put("WEBSOCKET_USERNAME", userId);  
        }  
        return true;  
    }  
  
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {  
        System.out.println("After Handshake");  
    }  
}  