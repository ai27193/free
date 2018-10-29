<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./pages/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function jumpToLogin(){		 
		 window.self.location = "${ctx}/pages/login.jsp";
	}   
	function jumpToRegister(){		 
		 window.self.location = "${ctx}/pages/register.jsp";         
	}
</script>
</head>
<body>
	<button type="button" name="toLogin" onclick="jumpToLogin()">进入登录页面</button> 
	<button type="button" name="toRegister" onclick="jumpToRegister()">进入注册页面</button>   
</body>
</html>

