<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- 세션을 이용한 로그인 처리 -->
<%
	String id = (String) session.getAttribute("id");

	//처음 로그인이 되어 있지 않다면 
	if(id== null) {
		id="GUEST";	
	}
%>
<body>
	<table width="1000"  border="1">
		<tr height="70">
			<td colspan="4" width="800">
				<a href="RentcarMain.jsp" style="text-decoration:none">
							<!--img/RENT.jsp -->
				<img alt="" src="" height="65">
			</td>
			<td align="center" width="200">
				<%= id %> 님
		<%
			if(id.equals("GUEST")) {
		%>
		
				<button onclick="location.href='RentcarMain.jsp?center=MemberLogin.jsp'">로그인</button>
		
		<%	
			}else {
		%>		
		
				<button onclick="location.href='MemberLogout.jsp'">로그아웃</button>
				
		<%	
			}
		%>
		
			</td>
		<tr>
		<tr height="50">
			<td align="center" width="200" bgcolor="">
										   <!-- CarReserveMain.jsp -->
				<font color="" size="5"><a href="RentcarMain.jsp?center=CarReserveMain.jsp" style="text-decoration:none">예약하기</a></font>
 			</td>
 			<td align="center" width="200" bgcolor="">
				<font color="" size="5"><a href="RentcarMain.jsp?center=CarReserveView.jsp" style="text-decoration:none">예약확인</a></font>
 			</td>
 			<td align="center" width="200" bgcolor="">
				<font color="" size="5"><a href="#" style="text-decoration:none">자유게시판</a></font>
 			</td>
 			<td align="center" width="200" bgcolor="">
				<font color="" size="5"><a href="#" style="text-decoration:none">이벤트</a></font>
 			</td>
 			<td align="center" width="200" bgcolor="">
				<font color="" size="5"><a href="#" style="text-decoration:none">고객센터</a></font>
 			</td>
		<tr>
	
	
	</table>

</body>
</html>