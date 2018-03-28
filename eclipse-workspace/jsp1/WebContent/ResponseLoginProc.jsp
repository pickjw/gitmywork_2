<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
		<!-- response.sendRedirect("ResponseMain.jsp?id="+id); 버터픠 내용이 사라짐-->
		<h2> 로그인 처리 페이지</h2>

		<%
		
			request.setCharacterEncoding("UTF-8");
	     	//request.setCharacterEncoding("UTF-8"); post한글 꺠짐 방지
	     	
			//임의적으로 id와 pass설정
			String dbid = "aaaa";
			String dbpass = "1234";
			
			//사용자로부터 넘어온 데이터를 입력 받아줌
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");

			//비교문을 써서 다음 페이지로 넘겨 줘야한다.
			if(dbid.equals(id) && dbpass.equals(pass)) {
				
				
				//아이디와 패스워드가 일치 하기에 메인페이지를 보여 줘야한다.
				response.sendRedirect("ResponseMain.jsp?id="+id);
				
			}else {
			
		%>
		
			<script>
			 	alert("아이디와 패스워드가 일치 하지 않습니다.")
				history.go(-1);
			</script>
			
		<%		
				
			}
		%>

</body>
</html>