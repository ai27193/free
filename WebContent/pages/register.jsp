<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./common/taglib.jsp" %>
<%@ include file="./common/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <script src="../ref/jquery-1.9.1.min.js"></script>
<script src="../ref/json2.js"></script>  -->
<script type="text/javascript">
function register(){
	if($.trim($("#randid").val())==""){
		alert("请输入验证码");
		return false;
	}			
	var val = $("#register_form").eSerializeObject();//调用自定义的扩展方法
	
	var jsonStr = JSON.stringify(val);		
	$.ajax({
		url:"${ctx}/register.spring?t="+new Date().getTime()+ "&randnum=" + $.trim($("#randid").val()),
		type:"POST",
		contentType:"application/json",
		data:jsonStr,
		success:function(jd){
			if(jd.success){
				alert(jd.data['phone']+","+jd.msg);
			}else{
				alert(jd.msg);
			}
		}
	}); 
}  
function rands(){
	alert("sssss");
	if($.trim($("#phone").val())==""){
		alert("请输手机号码");
		return false;
	}	
	var val = $("#register_form").eSerializeObject();//调用自定义的扩展方法	
	var jsonStr = JSON.stringify(val);		
	$.ajax({
		url:"${ctx}/foudrandnum.spring?t="+new Date().getTime(),
		type:"POST",
		contentType:"application/json",
		data:jsonStr,
		success:function(jd){
			if(jd.success){
				alert(jd.msg);
				$("#findrandnum").val("已发送")
				$("#findrandnum").disabled=ture;
			}else{
				alert("失败");
			}
		}
	}); 
}
</script>
</head>
<body>	
	<form id="register_form" action="#" enctype="multipart/form-data">
		手机号:<input id="phone" type="text" name="phone" value=""/><br>
		密码:<input type="text" name="password" value=""/><br>
		昵称:<input type="text" name="name" value=""/><br>
		邮箱:<input type="text" name="password" value=""/><br>
		验证码:<input id="randid" type="text" name="randnum" value=""/>
		<input id="findrandnum" type="button" onclick="rands()"  value="获取验证码"/><br>
		<input id="registerBtn" type="button" onclick="register()"  value="注册"/>
	</form>		
</body>
</html>
