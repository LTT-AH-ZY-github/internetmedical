package com.medical.controller;


import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import com.push.websocket.WebSocketHandler;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
/** 
 * 测试类 
 */  
  
@Controller
@RequestMapping(value="/test")
public class PageController {  
	
  
    /*@Bean//这个注解会从Spring容器拿出Bean  
    public WebSocketHandler infoHandler() {  
        return new WebSocketHandler();  
    }  */
    @RequestMapping("/login")  
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {  
        String username = request.getParameter("username");  
        System.out.println(username + "登录");  
        HttpSession session = request.getSession(false);  
        session.setAttribute("huanxinaccount", username); 
        System.out.println("测试数据"+session.getAttribute("huanxinaccount"));
        response.sendRedirect("websocket.jsp");  
    }  
  
    @RequestMapping("/send")  
    @ResponseBody  
    public String send(HttpServletRequest request) {  
        String username = request.getParameter("username");  
        new WebSocketHandler().sendMessageToUser(username, new TextMessage("你好，欢迎测试！！！！"));  
        return null;  
    }  
    
    @RequestMapping("/send2")  
    @ResponseBody  
    @ApiOperation(value = "判断手机号码是否注册", httpMethod = "POST", notes = "判断手机号码是否注册")
    public String send2(@ApiParam(name = "username", value = "手机号码") @RequestParam String username) {  
       WebSocketHandler.sendMessageToUser(username, new TextMessage("你好，欢迎测试！！！！"));  
        return null;  
    } 
}
