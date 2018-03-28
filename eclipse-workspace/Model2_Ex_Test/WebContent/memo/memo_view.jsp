<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<%@ include file="../include/header.jsp" %>
	<script type="text/javascript" src="../include/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
	function updateMemo() {
		var writer = $("#writer").val();
		var memo = $("#memo").val();
		if(writer == "") {
			alert("이름을 입력하세요");
			$("#writer").focus();
			return;
		}	
		if(memo == "") {
			alert("메모를 입력하세요");
			$("#memo").focus();
			return;
		}
		document.form1.action="${path}/memo_servlet/update.do";
		document.form1.submit();
	}
	function deleteMemo() {
		if(confirm("삭제하시겠습니까?")) {
			document.form1.action="${path}/memo_servlet/delete.do";
			document.form1.submit();
		}
		
	}
	</script>
</head>
<body>
	<h2>메모 수정</h2>
	<form action="#" method="post" name="form1">
		<table border="1" width="550px">
		
			<tr>
				<td>이름</td>
				<td> <!-- name => jsp   id=> jQuery -->
					<input name="writer" id="writer" value="${mdto.writer}"><!-- mdto.getWrite()가 호출됨 -->
				</td>		
			</tr>
			
			<tr>
				<td>메모</td>
				<td> <!-- name => jsp   id=> jQuery --> <!-- 컨트롤의 저장 request.setAttribute("mdto",mdto); -->
					<input name="memo" id="memo" value="${mdto.memo}"><!-- mdto.getMemo()가 호출됨 -->
				</td>		
			</tr>
			
			
			<tr>
				<td colspan="2">
								 <!-- name => jsp   id=> jQuery -->
					<input  type="hidden" name="idx" id="id" value="${mdto.idx}">
					<input  type="button" value="수정" onclick="updateMemo()">
					<input  type="button" value="삭제" onclick="deleteMemo()">
				</td>		
			</tr>
			
		</table>
	</form>
</body>
</html>