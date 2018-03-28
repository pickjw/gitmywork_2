package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginProc.do") // 어노테이션기능
public class LoginProc extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		rePro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		rePro(request, response);
	}
	
	//doGet 및 doPost 전부 받아줌
	public void rePro(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		//System.out.println("id ="+id);
		
		//request 객체에 데이터를 저장
		request.setAttribute("id", id);
		request.setAttribute("password", password);
		
		//
		RequestDispatcher dis = request.getRequestDispatcher("LoginProc.jsp");
		dis.forward(request, response);
	
	}
	
}
