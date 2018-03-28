<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

	<%
		request.setCharacterEncoding("UTF-8");
		//프로젝트에 만들어질 폴더를 저장할 변수 선언
		
		String realfolder="";
		//실제 만들어질 폴더명을 설정
		String savefolder="/upload";
		
		//한글설정
		String encType="UTF-8";
		
		int maxSize = 1024*1024*5; //5m
		
		//파일이 저장될 경로 값을 읽어 오는 객체
		ServletContext context = getServletContext();
		realfolder = context.getRealPath(savefolder);
		
		try {
			
			//클라이언트로 부터넘어온 데이터를 저장해주는 객체													//파일이름 변경을 자동
			MultipartRequest multi = new MultipartRequest(request, realfolder, maxSize, encType, new DefaultFileRenamePolicy());
	%>	
	
	  	 당신의 이름은<%=multi.getParameter("name") %>
	
	<%	
		out.print(realfolder);
		}catch (Exception e) {
			
			e.printStackTrace();
			
			
		}

	%>
</body>
</html>