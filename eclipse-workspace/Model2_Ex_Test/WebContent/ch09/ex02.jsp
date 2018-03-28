<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//pageContext.setAttribute("country", "korea");
%>
<c:set var="country" value="korea" scope="page" /> <!-- scope="page" 생략가능 -->
<c:if test="${country != null }">
<%-- 국가명 : <c:out value = "${country}" /><br> --%>
	 국가명 : ${country}<br>
</c:if>
<%
int[] nums={10,70,80,50,40,30,20};
//pageContext.setAttribute("num", nums);
%>
<c:set var="num" value = "<%=nums%>" />
<c:forEach var="n" items="${num}">
 	${n}, 
</c:forEach>
<br>
			<!-- switch ~ case ~ default 	
					다중조건문
					태그안에 주석금지 -> 에러남
			-->
			<c:set var="season" value="겨울"  />
			<c:choose>
				<c:when test="${season == '봄' }"><!-- 첫번쨰조건 -->
					<img src="/Model2_Ex_Test/images/spring.jpg">
				</c:when>
				<c:when test="${season == '여름' }">><!-- 두번쨰조건 -->
					<img src="/Model2_Ex_Test/images/summer.jpg">
				</c:when>
				<c:when test="${season == '가을' }"><!-- 세번쨰조건 -->
					<img src="/Model2_Ex_Test/images/autumn.jpg">
				</c:when>
				<c:when test="${season == '겨울' }"><!-- 4번쨰조건 -->
					<img src="/Model2_Ex_Test/images/winter3.jpg">
				</c:when>
				<c:otherwise><!-- 그밖에조건 -->
				잘못된 입력입니다.
				</c:otherwise>
			</c:choose>
























</body>
</html>