<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>
		<h2>회원 가입 양식</h2>
		<form action="MemberJoinProc.do" method="post">
			<table width="400" border="1" bordercolor="glay">
				<tr height="40">
					<td width="150" align="center">아이디</td>
					<td width="250"><input type="text" name="id"></td>
				</tr>
				
				<tr height="40">
					<td width="150"  align="center">패스워드</td>
					<td width="250"><input type="password" name="password"></td>
				</tr>	
				
				<tr height="40">
					<td width="150"  align="center">이메일</td>
					<td width="250"><input type="email" name="email"></td>
				</tr>	
				
				<tr height="40">
					<td width="150"  align="center">전화</td>
					<td width="250"><input type="tel" name="tel"></td>
				</tr>	
				
				<tr height="40">
					<td width="150"  align="center">주소</td>
					<td width="250"><input type="text" name="address"></td>
				</tr>	
				
				<tr height="40">
					<td colspan="2"  align="center"><input type="submit" value="회원가입"></td>
				</tr>			
			</table>
		</form>
	</center>
</body>
</html>