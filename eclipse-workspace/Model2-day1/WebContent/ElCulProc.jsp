<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>


	<center>
		<h2>결과보기</h2>


		<%
			String exp2 = request.getParameter("exp2");

			if (exp2.equals("+")) {
		%>
			결과는 ${ param.exp1 + param.exp3}

		<%
			}

			if (exp2.equals("-")) {
		%>
			결과는 ${ param.exp1 - param.exp3}

		<%
			}

			if (exp2.equals("*")) {
		%>
			결과는 ${ param.exp1 * param.exp3}

		<%
			}

			if (exp2.equals("/")) {
		%>
			결과는 ${ param.exp1 / param.exp3}

		<%
			}
		%>
	


	</center>

</body>
</html>