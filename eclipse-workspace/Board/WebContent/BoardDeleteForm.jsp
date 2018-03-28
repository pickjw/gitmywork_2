<%@page import="model.BoardBean"%>
<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<body>

	<%
     
		BoardDAO bdao = new BoardDAO();
	
		int num = Integer.parseInt(request.getParameter("num"));
	
		//하나의 게시글을 리턴받는다
		BoardBean bean = bdao.getOneUpdateBoard(num);
	

	%>
	<center>
		<h2>게시글 삭제</h2>
			<form action="BoardDeleteProc.jsp" method="post">
				<table width="600" border="1" bgcolor="">
					<tr height="40">
						<td width="120" align="center">작성자</td>
						<td width="180" align="center"><%=bean.getWriter() %></td>
						<td width="120" align="center">작성일</td>
						<td width="180" align="center"><%=bean.getReg_date() %></td>
					</tr>	
					<tr height="40">
						<td width="120" align="center">제목</td>
						<td colspan="3" align="center"><%=bean.getSubject()%></td>
				    </tr>
				    <tr height="40">
						<td width="120" align="center">패스워드</td>
						<td colspan="3" align="left"><input type="password" name="password" size="60"></td>
				    </tr>	
				    
				    <tr height="40">
						<td colspan="4" align="center">
							<input type="hidden" name="num" value="<%= bean.getNum() %>">
							<input type="submit" value="글삭제">&nbsp;&nbsp;
							<input type="button" value="목록보기" onclick="location.href='BoardList.jsp'"/>
						</td>
				    </tr>					
				</table>
			</form>
	</center>




</body>
</html>