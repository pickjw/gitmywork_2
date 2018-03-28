<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<%@ include file="../include/header.jsp" %>
	<script type="text/javascript" src="../include/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
	function gb_update() {
		var form1 = $("#form1");
		var gb_name = $("#gb_name");
		var gb_email = $("#gb_email");
		var gb_passwd = $("#gb_passwd");
		var gb_content = $("#gb_content");
		if(gb_name.val() == "" ) {
			alert("이름을 입력하세요");
			gb_name.focus();
			return;
		}
		if(gb_email.val() == "" ) {
			alert("이메일을 입력하세요");
			gb_email.focus();
			return;
		}
		if(gb_passwd.val() == "" ) {
			alert("비밀번호를 입력하세요");
			gb_passwd.focus();
			return;
		}
		if(gb_content.val() == "" ) {
			alert("내용을 입력하세요");
			gb_content.focus();
			return; 
		}  
		document.form1.action="${path}/guestbook_servlet/update.do";
		document.form1.submit();
	}
	function gb_delete() {
		if(confirm("삭제하시겠습니까?")) {
			document.form1.action="${path}/guestbook_servlet/delete.do";
			document.form1.submit();
		}	
	}
	</script>
</head>
<body>
	<h2>방명록 수정/삭제</h2>
	<form  name="form1" id="form1" method="post" >
		<table border="1" width="500px">
			<tr>
				<td>이름</td>
				<td><input name="gb_name" id="gb_name" size="40" value="${gdto.gb_name}"></td>
			</tr>
			
			<tr>
				<td>이메일</td>
				<td><input name="gb_email" id="gb_email" size="40" value="${gdto.gb_email}"></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="gb_passwd" id="gb_passwd" size="40"></td>
			</tr>
			
			<tr align="center">
				<td colspan="2">
					<textarea rows="5" cols="55" name="gb_content" id="gb_content">${gdto.gb_content}</textarea>
				</td>
			</tr>
			
			<tr align="center">
				<td colspan="2">
				<!-- 수정, 삭제를 위한 게시물 번호를 hidden tag에 저장 -->
					<input type="hidden" name="idx" value="${gdto.idx}">
					<input type="button" value="수정" onclick="gb_update()">
					<input type="button" value="삭제" onclick="gb_delete()">
					<input type="button" value="목록" onclick="location.href='${path}/guestbook_servlet/list.do'">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>