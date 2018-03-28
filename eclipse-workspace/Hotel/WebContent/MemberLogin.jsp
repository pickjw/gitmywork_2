<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<form action="MemberLoginProc.jsp" method="post">
		<table width="300" border="1" bordercolor="">
		
			<tr height="100" >
		 		<td colspan="2" align="center">
	 				<font size="6" color="black">로그인</font>
	 			</td>
	 		</tr>
		
			<tr height="40">
				<td width="120" align="center">아이디</td>
				<td width="180" align="center">
					<input type="text" name="id" size="15">
				</td>
			</tr>
			
			<tr height="40">
				<td width="120" align="center">패스워드</td>
				<td width="180" align="center">
					<input type="password" name="pass" size="15">
				</td>
			</tr>
			
			<tr height="40">
				<td colspan="2" align="center">
					<input type="submit" value="로그인">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>