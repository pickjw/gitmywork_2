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

@WebServlet("/BoardDeleteCon.do")
public class BoardDeleteCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//글삭제 부분 이기에 글번호를 입력
		int num = Integer.parseInt(request.getParameter("num"));
		
		//데이터 베이스에 접근하여 하나의 게시글을 리턴하는 메서드
		BoardDAO bdao = new BoardDAO();
		//DTO클래스 타입으로 리턴
		BoardDTO bdto = bdao.getOneUpdateBoard(num); //조회수를 증가 시키지 않는 메서드 이기에 삭제 시에도 메서드를 이용한다.
		
//------BoardDeleteForm.jsp쪽으로 request객체에 담아서 넘겨줌-------------------------------------------
		request.setAttribute("bdto", bdto);
		RequestDispatcher dis = request.getRequestDispatcher("BoardDeleteForm.jsp");
		dis.forward(request, response);
		
	}

}
