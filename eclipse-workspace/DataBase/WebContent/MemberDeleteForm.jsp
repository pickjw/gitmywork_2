<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
<center>
		<h2>회원 삭제 하기</h2>
		<table width="400" border="1">
			<form action="MemberDeleteProc.jsp" method="post">
				<tr height="50">
					<td align="center" width="150">아이디</td>
					<td align="" width="250"><%=request.getParameter("id")%></td>
				</tr>
				
				<tr height="50">
					<td align="center" width="150">패스워드</td>
					<td align="" width="250"><input type="password" name="pass1"></td>
				</tr>
				
				<tr height="50">
					<td align="center" colspan="2">
						<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
						<input type="submit" value="회원 삭제 하기"> &nbsp; &nbsp;</form><!-- 여기까지 db에 전송 -->
						<button onclick="location.href='MemberList.jsp'">회원전체보기</button>
					</td>
				</tr>
		</table>
	</center>
</body>
</html>