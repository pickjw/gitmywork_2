<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

	<%
		//사용자 컴퓨터의 쿠키 저장소로 부터 쿠키값을 읽어 드림  몇개인지 모르기에 배열을 이용하여 쿠키값을 저장
		Cookie[] cookies = request.getCookies();
		
		String id = "";
	
		//쿠기값이 없을 수도 있기에 null처리를 해줍니다.
		if(cookies != null) {
			
			for(int i=0; i<cookies.length; i++) {
				if(cookies[i].getName().equals("id")) {
					
					id = cookies[i].getValue();
					break;//우리가 원하는 데이터를 찾았기에 반복문을 빠져나옴
				}
				
			}
		}
	
	%>

	<center>
		<h2> 쿠키 로그인 </h2>
		<form action="CookieLoginProc.jsp" method="post">
			<table width="400" border="1">
				<tr height="50" >
					<td width="150">아이디</td>
					<td width="250"><input type="text" name="id" value=" <%=id%> "></td>
				</tr>
				
				<tr height="50" >
					<td width="150">패스워드</td>
					<td width="250"><input type="password" name="pass"></td>
				</tr>
				
				<tr height="50" >
					<td colspan="2" align="center"><input type="checkbox" name="save" value="1">아이디 저장</td>
				</tr>
				
				<tr height="50" >
					<td colspan="2" align="center"><input type="submit" value="로그인"></td>
				</tr>
		
			</table>
		</form>
	</center>
</body>
</html>