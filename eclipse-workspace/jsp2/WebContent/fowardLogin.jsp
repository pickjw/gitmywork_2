<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>
		<form action="ResponseProc.jsp" method="post">
			<table width="400" border="1">
				<tr height="50">
					<td	align="center" width="150">아이디</td>
					<td width="250"><input type="text" name="id" >
				</tr>
				
				<tr height="50">
					<td	align="center" width="150">패스워드</td>
					<td width="250"><input type="password" name="pass" >
				</tr>
				
				<tr height="50">
					<td	align="center" colspan="2">
						<input type="submit" value="로그인">&nbsp;&nbsp;<input type="reset" value="취소">
					</td>

				</tr>
			
			</table>
		</form>
	</center>

</body>
</html>