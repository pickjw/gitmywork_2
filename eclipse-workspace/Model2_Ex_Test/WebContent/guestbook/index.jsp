<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//Mapped Statements collection does not contain value for guestbook.gbList 에러발생
/* <mappers>
        <mapper resource="memo/mapper/memo.xml" />
        <mapper resource="guestbook/mapper/guestbook.xml" />
    </mappers> */


//컨텍스 패스 (웹프로젝트의 식별자)
String context = request.getContextPath();
//컨트롤러로 이동
response.sendRedirect(context+"/guestbook_servlet/list.do");
%>
</body>
</html>