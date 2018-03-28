<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>


 <%
 	//세션영역에 변수저장
 	session.setAttribute("name", "감자");
 	session.setAttribute("age", 19);
 	
 	//request 영역에 변수저장 sendRedirect할경우 저장 안됨 forward로 보내야한다
 	request.setAttribute("name", "감자");
 	request.setAttribute("age", 19);
 	 	
 	//페이지 이동
 	//response.sendRedirect("Seesion_request.jsp"); - 주소바뀜, 데이터 손실
 	//forward (주소 바뀌지 않음, 데이터유지)
 	RequestDispatcher dis = request.getRequestDispatcher("Seesion_request.jsp");
 	dis.forward(request, response);
 
 
 %>

</body>
</html>