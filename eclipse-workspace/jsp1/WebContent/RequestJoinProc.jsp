<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>
		<h2>회원정보 보기</h2>


		<%
			//post방식으로 데이터가 넘어 올떄 한글이 꺠질수 있기에
			request.setCharacterEncoding("UTF-8");//post한글 꺠짐 방지
			
			//각종 사용자로부터 넘어온 테이터를 저장해줌
			String id = request.getParameter("id");
			String pass1 = request.getParameter("pass1");
			String pass2 = request.getParameter("pass2");
			String email = request.getParameter("email");
			String tel = request.getParameter("tel");
			
			
			//getParameterValues 
			// []타입으로 리톤 받아야한다
			String[] hobby = request.getParameterValues("hobby");
			
			
			
			String job = request.getParameter("job");
			String age = request.getParameter("age");
			String info = request.getParameter("info");
			
			
			if(!pass1.equals(pass2)) {
	    %>		
		
		<script type="text/javascript">
			alert("비밀번호가 틀립니다.");
			history.go(-1);//이전 페이지로 이동
		
		</script>
				
		<%		
			}
			
		%>
			<table width="400" border="1">
				<tr height="50">
					<td width="150" align="center">아이디</td>
					<td width="350" align="center"> <%= id %></td>
				</tr>
				
				<tr height="50">
					<td width="150" align="center">이메일</td>
					<td width="350" align="center"><%= email %></td>
				</tr>
				
				<tr height="50">
					<td width="150" align="center">전화번호</td>
					<td width="350" align="center"><%= tel %></td>
				</tr>	
				
				<tr height="50">
					<td width="150" align="center">당신의 관심분야</td>
					<td width="350" align="center"> 
					<%
						for( int i =0; i<hobby.length; i++) {
							out.write(hobby[i]+" ");
							
						}
					
					%>
					</td><!--   hobby 는 배열이기에 그냥 하면 안됨 for문 돌리기 -->
				</tr>
				
				<tr height="50">
					<td width="150" align="center">직업</td>
					<td width="350" align="center"><%= job %></td>
				</tr>
				
				<tr height="50">
					<td width="150" align="center">연령</td>
					<td width="350" align="center"><%= age %></td>
				</tr>	
				
				<tr height="50">
					<td width="150" align="center">하고싶은말</td>
					<td width="350" align="center"><%= info %></td>
				</tr>	
			
			</table>


	</center>
</body>
</html>