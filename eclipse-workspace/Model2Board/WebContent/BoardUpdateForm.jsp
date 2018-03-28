<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>
		<h2>게시글 수정</h2>
		<form action="BoardUpdateProcCon.do" method="post">
				<table	width="600" border="1" bgcolor="">
				<tr height="40">
					<td align="center" width="120">작성자</td>
					<td align="center" width="180">${bdto.writer}</td>
					<td align="center" width="120">작성일</td>
					<td align="center" width="180">${bdto.reg_date}</td>
				</tr>
				<tr height="40">
					<td align="center" width="120">제목</td>
					<td width="480" colspan="3">&nbsp; <input type="text" name="subject" value="${bdto.subject}" size="70"></td>
				</tr>
				
				<tr height="40">
					<td align="center" width="120">패스워드</td>
					<td width="480" colspan="3">&nbsp; <input type="password" name="inputpassword" size="70"></td>
				</tr>
				
				<tr height="80">
					<td align="center" width="120">글내용</td>
					<td width="480" colspan="3"> <textarea rows="10" cols="60" name="content" align="Left">${bdto.content}</textarea></td>
				</tr>
				
				<tr height="40">
					<td colspan="4" align="center">
						<input type="hidden" name="num" value="${bdto.num}">
						<input type="hidden" name="password" value="${bdto.password}">
						<input type="submit" value="글수정">&nbsp; &nbsp;
						<input type="button" value="전체글보기" onclick="location.href='BoardListCon.do'">
					</td>	
				</tr>
		   </table>
		</form>
	</center>
</body>
</html>