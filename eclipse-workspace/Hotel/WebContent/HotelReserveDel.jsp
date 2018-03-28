<%@page import="db.HotelDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
		String id = request.getParameter("id");
		String rdayin = request.getParameter("rday");
		
		
		HotelDAO rdao = new HotelDAO();
		//예약삭제 메소드 호출
		rdao.carRemoveReserve(id, rdayin);
		
		response.sendRedirect("HotelMain.jsp");
	%>
<body>

</body>
</html>