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


@WebServlet("/BoardUpdateProcCon.do")
public class BoardUpdateProcCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글처리
		request.setCharacterEncoding("UTF-8");
		//BoardUpdateForm.jsp 넘어온 데이터 받기(DAO에 넘겨야함)
		int num = Integer.parseInt(request.getParameter("num"));
		String inputpassword = request.getParameter("inputpassword");
		String password = request.getParameter("password");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		//패스워드값과 사용자가 입력한 패스워값 비교
		if(inputpassword.equals(password)) { //패스워드가 같다면 데이터를 수정하시오!
			BoardDAO bdao = new BoardDAO();
			bdao.updateBoard(num,subject,content);
			//수정이 완료 되었다면 BoardListCon(전체게시글)
			request.setAttribute("msg", "0");
			RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
			dis.forward(request, response);
		}else {
			//비밀번호가 틀렸다면 이전 페이지로 넘어간다
			request.setAttribute("msg", "1");
			RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
			dis.forward(request, response);
		}
		
		
		
		
	}
}
