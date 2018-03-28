<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<%@ include file ="../include/header.jsp" %>
</head>
<body>
	<table border="1" width="500px">
		<tr> <!-- Table Row 테이블행 -->
			<th>번호</th> <!-- Table Header 제목셀 -->
			<th>이름</th>
			<th>메모</th>
			<th>날짜</th>
		</tr>
		<!-- var="개별값" items="리스트" -->
	<c:forEach var="row" items="${list}"> <!-- requestScope.list -->
		<tr>
			<td align="center">${row.idx}</td>
			<td>${row.writer}</td>
			<td>
				<a href="${path}/memo_servlet/view.do?idx=${row.idx}">${row.memo}</a>
			</td>
			<td align="center">${row.post_date}</td>
		</tr>
	</c:forEach>

	</table>
</body>
</html>