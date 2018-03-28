<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


		<%--
			횟수가 정해진 경우 
			<c:forEach var="카운터" begin="시작" end="끝"> 
			</c:forEach>
		
			횟수가 정해지지 않은 경우 ex)게시판 목록
			<c:forEach  var="개별값" items="집합"> 
			</c:forEach>
			
 		 --%>
 		 
 			<%--  <c:forEach var="i" begin="2" end="9"> 
 			 	<h2>${i}단</h2>
 			 	 <c:forEach var="j" begin="1" end="9"> 
 			 	 	${i} X ${j} = ${i*j}<br>
				</c:forEach>
			</c:forEach> --%>
 		 
 		 <%-- 	request.getParameter("변수") => ${param.변수 } --%>
 		<!--  http://localhost:8080/Model2_Ex_Test/ch09/ex04.jsp?start=5&end=9 -->
 		 	 <c:forEach var="i" begin="${param.start}" end="${param.end}"> 
 			 	<h2>${i}단</h2>
 			 	 <c:forEach var="j" begin="1" end="9"> 
 			 	 	${i} X ${j} = ${i*j}<br>
				</c:forEach>
			</c:forEach>
 		 
 		 
 		 
 		 
 		 
 		 
 		 

</body>
</html>