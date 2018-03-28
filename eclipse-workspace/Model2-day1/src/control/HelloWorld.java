package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloWorld.do")  
public class HelloWorld extends HttpServlet {   //HelloWorld라고 url에 표시 해주어야  서블릿 클래스가 실행 됩니다
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	//일괄처리
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//화면에 HelloWorld라고 출력 jsp쪽으로 넘겨질 데이터를 설정
		String msg = "Hello World~~~안녕하세요";
		Integer data = 12;
		
		
		//jsp쪽으로 데이터를 request에 부착하여 넘겨줌
		request.setAttribute("msg", msg);
		request.setAttribute("data", data);
		
		//db
		
		
		
		
		//서블릿에서 jsp를 호출+데이터를  같이 넘겨 주는 객체를 선언
		RequestDispatcher rd = request.getRequestDispatcher("HelloWorld.jsp"); //jsp파일명 기술
		rd.forward(request, response);
		
	}
	
}

