<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./common/taglib.jsp" %>
<%@ include file="./common/meta.jsp" %>
<%@ page import="java.util.Random"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function getForm(){	
		if($.trim($("#verifyId").val())==""){
			alert("请输入验证码");
			return false;
		}			
		var val = $("#login_form").eSerializeObject();//调用自定义的扩展方法
		
		var jsonStr = JSON.stringify(val);		
		$.ajax({
			url:"${ctx}/login.spring?t="+new Date().getTime()+ "&verify_code=" + $.trim($("#verifyId").val()),
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
	//刷新验证码
	function refreshCode(){
		//加上随机时间 防止IE浏览器不请求数据		
		var url = '${ctx}/generate.spring?t='+ new Date().getTime();		
	    $('#randCodeImage').attr('src',url);      
	}
</script>
</head>
<body>	
	<!-- <form id="login_form" action="loginCheck.spring" method="post">
		用户名:<input type="text" name="loginname" />	
		密码:<input type="text" name="password" />	
		<input type="submit"  value="登录"/>		
	</form>	 -->	
	
	<form id="login_form">
		手机:<input type="text" name="phone" value=""/>	
		密码:<input type="text" name="password" value=""/>
		验证码：<input id="verifyId" type="text" name="verify_code" value=""/>
		<img id="randCodeImage" alt="验证码"  src="${ctx}/generate.spring" width="90" height="30"/>
        <a href="javascript:void(0);" onclick="refreshCode()">看不清，换一个</a>
		<input type="button" onclick="getForm()"  value="登录"/>				
	</form>	
</body>
</html>