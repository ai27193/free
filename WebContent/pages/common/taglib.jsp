<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- ${header['host']}为主机地址和端口，${pageContext.request.contextPath}为部署的项目名 -->
<c:set var="ctx" value="http://${header['host']}${pageContext.request.contextPath}" />
