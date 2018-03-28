package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardDTO;

@WebServlet("/BoardUpdateCon.do")
public class BoardUpdateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//해당번호
		int num = Integer.parseInt(request.getParameter("num"));
		
		//데이터 베이스에서 하나의 게시글에 대한 대한 정보를 리턴 메소드 호출
		BoardDAO bdao = new BoardDAO();
		BoardDTO bdto = bdao.getOneUpdateBoard(num);
		
//------BoardUpdateForm.jsp쪽으로 request객체에 담아서 넘겨줌-------------------------------------------
		request.setAttribute("bdto", bdto);
		RequestDispatcher dis = request.getRequestDispatcher("BoardUpdateForm.jsp");
		dis.forward(request, response);
		
	}
}
