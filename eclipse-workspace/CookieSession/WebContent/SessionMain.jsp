<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
		//Center값을 변경해주기 위해서 request객체를 이용하여 center값을 받아옴
		String center = request.getParameter("center");
	
		//처음 SessionMaion.jsp를 실행하면 null값이 실행 되기에 null처리를 해줌
		if(center == null) {
			center = "Center.jsp";
		}
	
	
	%>


	<center>
		<table width="800"border="1">
		
			<!-- top -->
			<tr height="150">
				<td align="center" colspan="2"> 
					<jsp:include page="Top.jsp"></jsp:include>
					<%-- <%@ include file="Top.jsp" %> --%>
				</td>
			</tr>
			
			
			
				<!--Left -->
			<tr height="400">
			
				<td align="center" width="200"> 
					<jsp:include page="Left.jsp"/>	
				</td>			
			<!--center -->
				<td align="center" width="600"> 
					<jsp:include page="<%= center %>"/>	
				</td>
			</tr>
			
			
			
			<!--Bottom -->
			<tr height="100">
			
				<td align="center" colspan="2"> 
					<jsp:include page="Bottom.jsp"/>	
				</td>
			</tr>
		
	
		
		</table>
	</center>
</body>
</html>