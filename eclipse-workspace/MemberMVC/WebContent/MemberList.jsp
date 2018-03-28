<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<center>
		<h2>모든회원보기</h2>
		<table width="800" border="1" bordercolor="gray">
			<tr height="40">
				<td align="center" width="50">아이디</td>
				<td align="center" width="200">이메일</td>
				<td align="center" width="150">전화</td>
				<td align="center" width="150">취미</td>
				<td align="center" width="150">직업</td>
				<td align="center" width="100">나이</td>					
			</tr>
			
			
		<c:forEach var="mdto" items="${arrayList}" >
		
			<tr height="40">
				<td align="center" width="50"> ${mdto.id} </td>
				<td align="center" width="200"><a href="#">${mdto.email}</a>a></td>
				<td align="center" width="150">${mdto.tel}</td>
				<td align="center" width="150">${mdto.hobby}</td>
				<td align="center" width="150">${mdto.job}</td>
				<td align="center" width="100">${mdto.age}</td>					
			</tr>
		</c:forEach>
			
			
		</table>
	</center>
	




</body>
</html>