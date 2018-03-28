<%@page import="db.HotelDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

		<%	
			request.setCharacterEncoding("UTF-8");
			
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			//회원아이디와 패스워드가 일치 하는지 비교
			HotelDAO hdao = new HotelDAO();
			
			//해당회원이 있는지 여부를 숫자로 표현
			int result = hdao.getMember(id, pass);
			
			if(result==0) {
		%>	
				<script type="text/javascript">
					alert("회원 아이디 또는 패스워드가 틀렸습니다.");
					location.href="HotelMain.jsp?center=MemberLogin.jsp";
				</script>		
		<%	
			}else {
				//로그인 처리가 되었다면
				session.setAttribute("id", id);
				response.sendRedirect("HotelMain.jsp");
			}
			
		%>
				
</body>
</html>