<%@page import="java.util.List"%>
<%@page import="model.MemberDTO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		function view(userid) {
			document.form1.userid.value = userid;
			document.form1.submit();
			
		}
	
	</script>
</head>
<body>

<%  

	Map<String,Object> map = (Map<String,Object>) request.getAttribute("map");
	List<MemberDTO> list = (List<MemberDTO>) map.get("list");
	 int count = list.size();   /*  int count = list.size();		int count = (int)map.get("count"); */
%>
등록된 회원수 :<%=count %> 명  
	<table border="1" width="600px">
		<tr>
			<th>이름</th>	
			<th>아이디</th>	
			<th>가입일자</th>	
			<th>이메일</th>	
			<th>핸드폰</th>	
		</tr>
		
		<% 
		   for (MemberDTO mdto : list) { 
		%>
		<tr>
			<td>
				<a href="#" onclick="view('<%=mdto.getUserid() %>')"><%=mdto.getUsername() %></a>
			</td>	
			<td><%=mdto.getUserid() %></td>
			<td><%=mdto.getJoin_date() %></td>	
			<td><%=mdto.getUseremail() %></td>	
			<td><%=mdto.getPhone()%></td>	
		</tr>
		<%	
			}	
		%>
	</table>
	<form action="/Model2_DriveTest/control_servlet/view.do" method="post" name="form1">
		<input type="hidden" name="userid">
	
	</form> 

</body>
</html>