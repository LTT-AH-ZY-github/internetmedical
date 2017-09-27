<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json交互测试</title>

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