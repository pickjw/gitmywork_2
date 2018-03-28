<%@page import="model.MemberDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>


	<%
		request.setCharacterEncoding("UTF-8");//한글처리

		//취미부분은 별도로 읽어드려 다시 빈클래스에 저장 -String[]->getParameterValues
		String[] hobby = request.getParameterValues("hobby");

		//배열의 있는 내용을 하나의 스트링으로 저장
		String texthobby = "";
		for (int i = 0; i < hobby.length; i++) {
			texthobby += hobby[i] + " ";//뜨워쓰기 용도 공백

		}
	%>


	<jsp:useBean id="mbean" class="model.MemberBean">
		<jsp:setProperty name="mbean" property="*" /><!-- 맵핑시키기 -->
	</jsp:useBean>




	<%
		//기존 취미는 배열객체의 주소 번지가 저장 되기때문에  배열의 내용을 하나의 스트링으로 저정한 변수를 다시 입력
		mbean.setHobby(texthobby);
	
		//데이터 베이스 클랙스 객체 생성
		MemberDAO mdao = new MemberDAO();
		mdao.insertMember(mbean);
		
		//회원가입이 되었다면 회원정보를 보여주는 페이지로 이동시킴
		response.sendRedirect("MemberList.jsp");
		
	%>



	



</body>
</html>