<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页封装</title>
    <meta name="Keywords" content="大益行情，普洱茶,大益,雨林古茶坊,中期茶,新茶,中期茶报价,茶通超市,大益价格,大益报价" />
    <meta name="Description" content="东和茶叶创建于2008年，位于广州芳村南方茶叶市场，是一家以经营知名品牌“大益”普洱茶的中介批发商。公司自成立之时，便秉承“诚信、公平、双赢”核心价值观，立足于芳村茶叶市场，经营网络遍布全国各大省市，与广大茶商有着密切友好的合作。" />
    <link href="css/fenye.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--咨询内容图片文字-->
 <!--分页   -->
<div class="blank"></div>
<div class="pagesbox">
    <form name="selectPageForm" action="fenyehangqing.spring" method="get">
        <div class="pager_record">总共<font class="f1">${total}</font>个记录</div>
        <div class="pagebar">
              <a href="<c:url value="/fenyehangqing.spring?page=${page-1>1?page-1:1}"/>">< 上一页</a>
                 <%--中间页--%>
                <%--显示5页中间页[begin=起始页,end=最大页]--%>
                 <%--总页数没有5页--%>
        <c:choose>
        <c:when test="${totalPages <= 5}">
            <c:set var="beginpage" value="1"/>
            <c:set var="endpage" value="${totalPages}"/>
        </c:when>
        <%--页数超过了5页--%>
        <c:otherwise>
            <c:set var="beginpage" value="${page - 1}"/>
            <c:set var="endpage" value="${page + 3}"/>
            <%--如果begin减1后为0,设置起始页为1,最大页为5--%>
            <c:if test="${beginpage -1 <= 0}">
                <c:set var="beginpage" value="1"/>
                <c:set var="endpage" value="5"/>
            </c:if>
             <%--如果总页数大于5，当前页小于5，中间页不动--%>
            <c:if test="${page<= 5}">
                <c:set var="beginpage" value="1"/>
                <c:set var="endpage" value="5"/>
            </c:if>
             <%--如果总页数大于5当前页大于5，当前变中间--%>
            <c:if test="${page>= 5}">
                <c:set var="beginpage" value="${page - 2}"/>
                <c:set var="endpage" value="${page +2}"/>
            </c:if>
             <%--如果end超过最大页,设置起始页=最大页-5--%>
            <c:if test="${page+1 >=totalPages}">
                <c:set var="beginpage" value="${page - 3}"/>
                <c:set var="endpage" value="${totalPages}"/>
            </c:if>
            <%--如果end超过最大页,设置起始页=最大页-5--%>
            <c:if test="${page >= totalPages}">
                <c:set var="beginpage" value="${totalPages - 4}"/>
                <c:set var="endpage" value="${totalPages}"/>
            </c:if>
        </c:otherwise>
       </c:choose>               
              <!--   遍历       -->
                 <c:forEach begin="${beginpage}" end="${endpage}" varStatus="loop">
                  <c:set var="active" value="${loop.index==page?'page_now':''}"/>
                    <a class="${active}" href="<c:url value="/fenyehangqing.spring?page=${loop.index}"/>">${loop.index}</a>
                </c:forEach>
            
            <%--中间页结束--%>
            <a href="<c:url value="/fenyehangqing.spring?page=${page+1<totalPages?page+1:totalPages}"/>">下一页></a>
       
        </div>
        <div class="pager_count">共${totalPages}页</div>
        <div class="submit_go">
            第<input type="text" name="page" size="2" class="input_go" value="${page}" align="absmiddle" />页
            <input type="submit" value=""  class="submit_btn_go" align="absmiddle" />
        </div>
    </form>
</div>
<div class="blank"></div>
<!--分页结束-->

</body>
</html>