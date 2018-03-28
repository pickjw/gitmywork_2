<%@page import="model.MemberBean"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<!-- 
	0.memberlist에서 넘긴 id를 받아줌
	
	1.데이터 베이스에서 1명 회원의 정보를 가져옴 
	
	2.table태그를 이용하여 화면에 회원의 정보를 출력 
	-->

	<%
		
		//request.setCharacterEncoding("UTF-8");//한글처리
	
		String id = request.getParameter("id");//memberlist에서 넘긴거 받아줌

		MemberDAO mdao = new MemberDAO();
		//1명의 회원정보
		MemberBean mbean = mdao.oneSelectMember(id);//해당하는 id의 회원정보를 리컨
	%>

	<center>
		<h2>회원 정보 수정하기</h2>
		<table width="400" border="1">
			<form action="MemberUpdateProc.jsp" method="post">
				<tr height="50">
					<td align="center" width="150">아이디</td>
					<td align="" width="250"><%=mbean.getId()%></td>
				</tr>
				
				<tr height="50">
					<td align="center" width="150">이메일</td>
					<td align="" width="250"><input type="email" name="email" value="<%=mbean.getEmail()%>"></td>
				</tr>
				
				<tr height="50">
					<td align="center" width="150">전화</td>
					<td align="" width="250"><input type="tel" name="tel" value="<%=mbean.getTel()%>"></td>
				</tr>
				
				<tr height="50">
					<td align="center" width="150">패스워드</td>
					<td align="" width="250"><input type="password" name="pass1"></td>
				</tr>
				
				<tr height="50">
					<td align="center" colspan="2">
						<input type="hidden" name="id" value="<%=mbean.getId()%>">
						<input type="submit" value="회원수정하기"> &nbsp; &nbsp;</form>
						<button onclick="location.href='MemberList.jsp'">회원전체보기</button>
					</td>
				</tr>
		</table>
	</center>

</body>
</html>