<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>



 		 <%
 			String pass = request.getParameter("pass");
 		
 			int num = Integer.parseInt(request.getParameter("num"));
 		
 			//db연결
 			BoardDAO bdao = new BoardDAO();
 			String password = bdao.getPass(num);
 		
 		 	//기본 패스워드 값과 delete Form에서 작성한 패스워드를 비교한다.
 		 	if(password.equals(password)) {
 		 		
 		 		
 		 		//패스워드가 둘다 같다면!
 		 		bdao.deleteBoard(num);
 		 		response.sendRedirect("BoardList.jsp");
 		 		
 		 	}else {
 		%>		
 		
 		  <script type="text/javascript">
 		  	alert("패스워드가 틀려서 삭제 할수 없습니다. 패스워드를 확인해 주세요");
 		  	history.go(-1);
 		  </script>
 		  	
 		<%	
 		 	}
 		
 		%>



</body>
</html>