<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<!-- 개별값을 출력 할 경우 -->
<%-- ${변수.속성} <=> ${변수["속성"]} --%>
<%-- ${map.포도}<br> =>한글괴 특수문자는 500에러 --%>
${map["포도"]}<br>
${map["오렌지"]}<br>
${map["바나나"]}<br>
${map["사과"]}<br>
<!-- 모두출력할경우 -->
<!-- map.put("key","value"); -->
<c:forEach var="row" items="${map }">
	${row} : ${row.key} => ${row.value}<br>
	${row} : ${row["key"]} => ${row["value"]}<br>
</c:forEach>
-------------------------<br>
포도=grape : 포도 => grape <br>
오렌지=orange : 오렌지 => orange <br>
사과=apple : 사과 => apple <br>
바나나=banana : 바나나 => banana <br>

<%-- <%@ page import = "java.util.HashMap" %>
<%
//map.set("변수명",값) map.get("변수명")
HashMap<String,String> map =
	(HashMap<String,String>) request.getAttribute("map");
String[] fruits = {"포도","오렌지", "바나나", "사과"};
for(String f : fruits) {
	
	out.println(f+"==>"+map.get(f)+"<br>");
}
%> --%>

</body>
</html>