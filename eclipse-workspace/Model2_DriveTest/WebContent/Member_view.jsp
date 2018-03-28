<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
<%-- <script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.js"></script> --%>
	<script type="text/javascript" src="./include/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
	$(function(){
		//id가 btnUpdate인 태그를 클릭하면
		$("#btnUpdate").click(function(){
			//폼데이터를 제출할 주소
			document.form1.action="/Model2_DriveTest/control_servlet/update.do";
			//폼데이터를 서버에 제출
			document.form1.submit();
		});
		$("#btnDelete").click(function(){
			if(confirm("삭제하시겠습니까?")) {
				//폼데이터를 제출할 주소
				document.form1.action="/Model2_DriveTest/control_servlet/delete.do";
				//폼데이터를 서버에 제출
				document.form1.submit();
			}
		});
		
		
	}); 
	</script>	
</head>
<body>
<%
	MemberDTO mdto = (MemberDTO) request.getAttribute("mdto");

%>
	<form method="post" name="form1">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><%= mdto.getUserid() %></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="userpass" value="<%=mdto.getUserpass()%>">
				</td>
			</tr>		
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="username" value="<%=mdto.getUsername()%>">
				</td>
			</tr>
			<tr>
				<td>회원가입 일자</td>
				<td>
					<input type="text" name="join_date" value="<%=mdto.getJoin_date()%>">
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="email" name="useremail" value="<%=mdto.getUseremail()%>">
				</td>
			</tr>	
			<tr>
				<td>휴대폰</td>
				<td>
					<input type="text" name="phone" value="<%=mdto.getPhone()%>">
				</td>
			</tr>	
			<tr>
				<td colspan="2" align="center">
					<input type="hidden" name="userid" value="<%= mdto.getUserid() %>">
					<button type="button" id="btnUpdate">수정</button>
					<button type="button" id="btnDelete">삭제</button>
				</td>
				
			</tr>							
		</table>
	</form>

</body>
</html>