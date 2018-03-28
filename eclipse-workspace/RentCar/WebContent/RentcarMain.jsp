<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<center>

<%
	String center = request.getParameter("center");

	//처음 실행시 센터값이 넘어 오지 않게
	if(center== null) {//null처리해줌
		center="Center.jsp";//디폴트 Center값을 부여
		
	}
%>

	<table width="1000" >
	
			<!-- Top  -->
			<tr height="140" align="center">
				<td width="1000" align="center">
					<jsp:include page="Top.jsp"></jsp:include>
				</td>
			</tr>
			
			
			<!--Center  -->
			<tr height="470" align="center">
				<td width="1000" align="center">
					<jsp:include page="<%=center %>"></jsp:include>
				</td>
			</tr>
			
			
			<!-- Bottom  -->
			<tr height="100" align="center">
				<td width="1000" align="center">
					<jsp:include page="Bottom.jsp"></jsp:include>
				</td>
			<tr>
			
			
		</table>
	</center>
</body>
</html>