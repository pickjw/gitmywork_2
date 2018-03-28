<%@page import="model.BookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%
	BookDAO dao = new BookDAO();
	ArrayList<BookDTO> arrayList = dao.getBookList();
%>
<ul>
<% for(BookDTO bdto : arrayList ) {  %>
	<li><%=bdto.getTitle() %></li>
<% }%>
</ul>



</body>
</html>