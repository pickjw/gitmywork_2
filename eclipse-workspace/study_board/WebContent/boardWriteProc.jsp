<%@ page import="model.BoardDAO" %><!--BoardDAO bdao = new BoardDAO();  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

	<%
		request.setCharacterEncoding("UTF-8");//한글처리
	
	%>
	<!-- 게시글에서 작성한 데이터를 한번에 읽어드림  -->
<jsp:useBean id="boardbean" class="model.BoardBean">
		   <!-- 사용하고 있는 빈클래스 이름 적기  ,  property(맴핑시키기) 없는것은 null값 처리됨 -->
	<jsp:setProperty name="boardbean"  property="*" />
</jsp:useBean>

	<%
		//데이터 베이스 쪽으로 빈클래스를 넘겨줌
		BoardDAO bdao = new BoardDAO();
	
		//데이터 저장 메소드를 호출
		bdao.insertBoard(boardbean);
	
		
	
	%>
	
	
	
	

</body>
</html>