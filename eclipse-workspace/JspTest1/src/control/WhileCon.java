package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")// *.do /WhileCon.do /*.do X에러걸림
public class WhileCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number = Integer.parseInt(request.getParameter("number"));
		int num = Integer.parseInt(request.getParameter("num"));
		int result = 1;
		for (int i=1; i<=num; i++) {
			result *= number;
		}
		System.out.println("결과:" +result);
//~~~~~~~~~~~~~~~~~~WhileResult.jsp보내기~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		request.setAttribute("result", result);
		RequestDispatcher dis = request.getRequestDispatcher("WhileResult.jsp");
		dis.forward(request, response);
	}

}

















