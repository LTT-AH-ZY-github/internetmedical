<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json交互测试</title>
<script>  
<%--     var path = '<%=basePath%>';  
    var userId = 'lys';  
    if(userId==-1){  
        window.location.href="<%=basePath2%>";  
    }   --%>
    var jspCode = userId+"_AAA";  
    var websocket;  
    if ('WebSocket' in window) {  
        websocket = new WebSocket("ws://" + path + "wsMy?jspCode=" + jspCode);  
    } else if ('MozWebSocket' in window) {  
        websocket = new MozWebSocket("ws://" + path + "wsMy?jspCode=" + jspCode);  
    } else {  
        websocket = new SockJS("http://" + path + "wsMy/sockjs?jspCode=" + jspCode);  
    }  
    websocket.onopen = function(event) {  
        console.log("WebSocket:已连接");  
        console.log(event);  
    };  
    websocket.onmessage = function(event) {  
        var data = JSON.parse(event.data);  
        console.log("WebSocket:收到一条消息-norm", data);  
        alert("WebSocket:收到一条消息");  
    };  
    websocket.onerror = function(event) {  
        console.log("WebSocket:发生错误 ");  
        console.log(event);  
    };  
    websocket.onclose = function(event) {  
        console.log("WebSocket:已关闭");  
        console.log(event);  
    }  
</script>  
<script type="text/javascript">


//请求json，输出是json
function requestJson(){
	alert(11)
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/user/login',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串，商品信息
		data:'{"userloginusername":"熊阳辉","userloginpassword":"8e296a067a37563370ded05f5a3bf3ec","userloginlastlogintime":"Jul 14, 2017 22:34:31"}',
		success:function(data){//返回json结果
			alert(data.state);
		}
		
	});
	
	
}
//请求key/value，输出是json
function responseJson(){
	alert(55)
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/user/register',
		contentType:'application/json;charset=utf-8',
		data:'{"userloginusername":"熊阳辉"}',
		success:function(data){ //返回json结果
			alert(data.state);
		}
		
	});
	
}
</script>

<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script></head>
<body>
<input type="button" onclick="requestJson()" value="请求json，输出是json"/>
<input type="button" onclick="responseJson()" value="请求key/value，输出是json"/>
</body>
</html>