<%@page import="model.BoardBean"%>
<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>


	<%
	
		request.setCharacterEncoding("UTF-8");
	
	
	
	%>
           <!-- 게시글 작성한 데이터를 한번에 읽기 -->
	<jsp:useBean id="boardbean" class="model.BoardBean">
		<jsp:setProperty name="boardbean"  property="*" /> <!-- 1대1 맴핑 -->
	</jsp:useBean>



		
	<% 
		//데이터 베이스쪽으로 빈클래스를 넘겨줌 BoardBean
		BoardDAO bdao = new BoardDAO();
	
		//데이터 저장 메소드를 호출
		bdao.insertBoard(boardbean);
		
		//게시글 저장후 전체게시글 보기
		response.sendRedirect("BoardList.jsp");
	
	%>


</body>
</html>