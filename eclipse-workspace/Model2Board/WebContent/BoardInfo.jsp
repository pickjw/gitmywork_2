<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<center>
		<h2> 게시글 보기</h2>
		<table	width="600" border="1" bgcolor="">
			<tr height="40">
				<td align="center" width="120">글번호</td>
				<td align="center" width="180">${bdto.num}</td>
				<td align="center" width="120">조회수</td>
				<td align="center" width="180">${bdto.readcount}</td>
			</tr>
			<tr height="40">
				<td align="center" width="120">작성자</td>
				<td align="center" width="180">${bdto.writer}</td>
				<td align="center" width="120">작성일</td>
				<td align="center" width="180">${bdto.reg_date}</td>
			</tr>
			
			<tr height="40">
				<td align="center" width="120">이메일</td>
				<td align="center" colspan="3">${bdto.email}</td>
			</tr>
			<tr height="40">
				<td align="center" width="120">글제목</td>
				<td align="center" colspan="3">${bdto.subject}</td>
			</tr>
			
			<tr height="80">
				<td align="center" width="120">글내용</td>
				<td align="center" colspan="3">${bdto.content}</td>
			</tr>
			
			<tr height="40">
				<td align="center" colspan="4">         <!-- 제일중요 부분 ref, re_step, re_level -->        
					<input type="button" value="답글쓰기" 
					onclick="location.href='BoardReWriteCon.do?num=${bdto.num}&ref=${bdto.ref}&re_step=${bdto.re_step}&re_level=${bdto.re_level}'">
					<input type="button" value="수정하기" onclick="location.href='BoardUpdateCon.do?num=${bdto.num}'">
					<input type="button" value="삭제하기" onclick="location.href='BoardDeleteCon.do?num=${bdto.num}'">
					<input type="button" value="목록보기" onclick="location.href='BoardListCon.do'">
				</td>
			</tr>
		</table>
	</center>
</body>
</html>