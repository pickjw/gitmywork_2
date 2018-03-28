<%@page import="java.net.URLEncoder"%><!-- //특수문자, 한글등은 인코딩해야함 (톰캣 9.0안해도 되는 것 같음)  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	
	//new Cookie("쿠키변수명","값") 스트링만 가능
	//특수문자, 한글등은 인코딩해야함 (톰캣 9.0안해도 되는 것 같음)
	Cookie cookie = new Cookie("id", URLEncoder.encode("김철수","UTF-8"));
    //URLEncoder.encode 를 받는쪽은 -> URLDecoder.decode("");
    //URLDecoder.decode("%EA%B9%80%EC%B2%A0%EC%88%98","UTF-8")
	//Cookie cookie = new Cookie("id","김철수"); ->500에러 확인 되어 인코딩 해야함
	
	Cookie cookie2 = new Cookie("pass","1234");
	Cookie cookie3 = new Cookie("age","20");//스트링만 가능
	cookie.setMaxAge(10);//쿠키의 유효시간(초)
	response.addCookie(cookie);//쿠키생성
	response.addCookie(cookie2);
	response.addCookie(cookie3);
%>
 쿠기가 생성 되었습니다.<br>
<!--  <a href="UseCookie.jsp">쿠키확인</a> -->
<!-- 크로스브라우징 ( 현재 한글 에러 이기에 인코딩 해야함-->
<%
	String name = URLEncoder.encode("박상민","UTF-8");
%>
 <a href="UseCookie.jsp?name=<%=name%>">쿠키확인</a>
</body>
</html>