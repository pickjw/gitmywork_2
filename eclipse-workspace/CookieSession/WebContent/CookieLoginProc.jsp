<%@page import="javax.servlet.http.Cookie"%><!--  쿠키를 사용하려면 - 쿠키클래스를 생성해주어야 함 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>


	<%
		request.setCharacterEncoding("UTF-8");
		//out.write("아이디저장 ="+request.getParameter("save"));
		//아이디 저장 체크 박스가 체크 되었는지 판단여부
		String save = request.getParameter("save");
		
		//아이디 값 저장
		String id = request.getParameter("id");
		
		//체크되었는지를 비교 판단
		if(save != null) {//아이디 체크가 되었다면(null이 아니라면)
	
		//쿠키를 사용하려면 - 쿠키클래스를 생성해주어야 함 
		Cookie cookie = new Cookie("id", id);//1.번쨰 String 키값을 적어줌 , 2번쨰는 value값을 넣어줌
		
		//쿠키유효시간 설정
		cookie.setMaxAge(60*10);//10분간 유효합니다.
		
		//사용자에게 쿠카 값을 넘겨줌
		response.addCookie(cookie);
		
		
		out.write("쿠키생성완료 ");
		
		}
		
		
	
	%>

				


</body>
</html>