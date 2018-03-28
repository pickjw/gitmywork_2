<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<%@ include file="./include/Header.jsp" %>
	<script type="text/javascript">
		function view(userid) {
			document.form1.userid.value = userid;
			document.form1.submit();
			
		}
	
	</script>
</head>
<body>


등록된 회원수 : ${map.count }명  
	<table border="1" width="600px">
		<tr>
			<th>이름</th>	
			<th>아이디</th>	
			<th>가입일자</th>	
			<th>이메일</th>	
			<th>핸드폰</th>	
		</tr>
 	<c:forEach var="mdto" items="${map.list}">
		<tr>
			<td>
				<a href="#" onclick="view('${mdto.userid}')">${ mdto.username}</a>
			</td>	
			<td>${ mdto.userid}</td>
			<td>${ mdto.join_date}</td>	
			<td>${ mdto.useremail}</td>	
			<td>${ mdto.phone}</td>	
		</tr>
	</c:forEach>
	</table>
	<form action="/Model2_DriveTest/control_servlet/view.do" method="post" name="form1">
		<input type="hidden" name="userid">
	
	</form> 

</body>
</html>