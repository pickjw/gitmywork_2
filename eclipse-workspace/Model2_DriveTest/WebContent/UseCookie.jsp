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
	//클라이언트에 지정된 쿠키값을 배열로 받음
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		//전체 쿠키값 볼경우
		for(int i=0; i<cookies.length; i++) {
			out.println("쿠키이름:"+cookies[i].getName());
			out.println(",쿠키값:"+cookies[i].getValue()+"<br>");
			
			//id만 필요할 경우
			/* if(cookies[i].getName().equals("id")){
				out.println("쿠키이름:"+cookies[i].getName());
				out.println(",쿠키값:"+cookies[i].getValue()+"<br>");	
			} */
			
			/* //age만 필요할 경우
			if(cookies[i].getName().equals("age")){
				out.println("쿠키이름:"+cookies[i].getName());
				out.println(",쿠키값:"+cookies[i].getValue()+"<br>");	
			} */
		}	
	}

%>

<!--  EL (Expression Language) 표현언어)-->
아이디 : ${cookie.id.value} <br>
비번 : ${cookie.pass.value} <br>
나이 : ${cookie.age.value} <br>
이름 : <%= request.getParameter("name") %><br><!-- 자바코드일경우  한글출력안됨--> 
이름:  ${param.name } <br>



<a href="DeleteCookie.jsp">쿠키삭제</a><br>
<a href="EditCookie.jsp">쿠키변경</a><br>





</body>
</html>