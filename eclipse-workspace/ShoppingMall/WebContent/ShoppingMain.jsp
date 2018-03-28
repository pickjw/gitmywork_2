<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>
	<table width="1200" >
	<tr height="60">
		<td align="center" width="1200">
		   <jsp:include page="TopofTop.jsp" />
		</td>
	</tr>
	<tr height="60">
		<td align="center" width="1200">
		   <jsp:include page="Top.jsp" />
		</td>
	</tr>
	<tr>
		<td align="center" width="1200">
		<jsp:include page="${center }" /> 
		</td>
	</tr>	
	<tr>
		<td align="center" width="1200">
		<jsp:include page="Bottom.jsp" />
		</td>
	</tr>
	
	</table>
</center>
</body>
</html>