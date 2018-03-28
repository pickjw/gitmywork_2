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
	function gb_search() {
		document.form1.action="${path}/guestbook_servlet/list.do";
		document.form1.submit();
	}
	</script>
</head>
<body>
	<h2>방명록</h2>
	${count}개의 글이 있습니다. <!-- requestScope.count 생략 -->
	
	<!-- 검색폼 -->
	<form name="form1" id="form1" method="post">
		<select name="searchkey" id="searchkey">
		<%-- 	if문의 경우 3번이나 검사 하기에 느릴수 있다. --%>
		<c:choose>
		    <c:when test="${searchkey == 'gb_name' }">
				<option value="gb_name" selected="selected">이름</option>
				<option value="gb_content">내용</option>
				<option value="name_content">이름+내용</option>
		    </c:when>
		    <c:when test="${searchkey == 'gb_content' }">
				<option value="gb_name" >이름</option>
				<option value="gb_content" selected="selected">내용</option>
				<option value="name_content">이름+내용</option>
		    </c:when>
		    <c:when test="${searchkey == 'name_content' }">
				<option value="gb_name" >이름</option>
				<option value="gb_content">내용</option>
				<option value="name_content" selected="selected">이름+내용</option>
		    </c:when>
		 </c:choose> 
		 
	<%-- 	if문의 경우 3번이나 검사 하기에 느릴수 있다.
	    <c:if test="${searchkey == 'gb_name' }">
			<option value="gb_name" selected="selected">이름</option>
			<option value="gb_content">내용</option>
			<option value="name_content">이름+내용</option>
	    </c:if>
	    <c:if test="${searchkey == 'gb_content' }">
			<option value="gb_name" >이름</option>
			<option value="gb_content" selected="selected">내용</option>
			<option value="name_content">이름+내용</option>
	    </c:if>
	    <c:if test="${searchkey == 'name_content' }">
			<option value="gb_name" >이름</option>
			<option value="gb_content">내용</option>
			<option value="name_content" selected="selected">이름+내용</option>
	    </c:if> --%>
		</select>
		<input name="search" id="search" value="${search}">
		<input type="button" value="조회" onclick="gb_search()">
	</form>

	<input type="button" value="글쓰기" onclick="location.href='${path}/guestbook/write.jsp'">
	
	<c:forEach var="gdto" items="${list}"> <!-- 컨트롤러의 request.setAttribute("list", items); 값과 맞아야함 -->
		<form  action="${path}/guestbook_servlet/passwd_ckeck.do" method="post"><!-- action="${path}/guestbook_servlet/passwd_ckeck.do" -->
			<!-- 편집을 위해서는 게시물 번호가 필요함 -->
			<input type="hidden" name="idx" value="${gdto.idx}">
			<table border="1" width="600px">
				<tr>
					<td>이름</td>
					<td>${gdto.gb_name}</td> 
				    <td>날짜</td>
					<td>${gdto.post_date}</td> 
				</tr>
				<tr>
					<td>이메일</td>
					<td colspan="3">${gdto.gb_email}</td>
				</tr>
				<tr>
					<td colspan="4">${gdto.gb_content}</td>
				</tr> 
			    <tr>
					<td colspan="4">
					 비밀번호 <input type="password" name="gb_passwd">
					 	   <input type="submit" value="수정/삭제">
					</td>
				</tr>

			</table>
		</form>
	</c:forEach>
</body>
</html>