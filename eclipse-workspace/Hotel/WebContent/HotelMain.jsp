<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%
		String center = request.getParameter("center");

		//처음 실행시 센터값이 넘어 오지 않게
		if (center == null) {//null처리해줌
			center = "Center.jsp";//디폴트 Center값을 부여

		}
	%>

	<div id="wrapper">

		<!-- Top  -->
		<div id="header">
			<jsp:include page="Top.jsp"></jsp:include>
		</div>


		<!--Center  -->
		<div id="Center">
			<jsp:include page="<%=center%>"></jsp:include>
		</div>


		<!-- Bottom  -->
		<div id="footer">
			<jsp:include page="Bottom.jsp"></jsp:include>
		</div>


	</div>
</body>
</html>