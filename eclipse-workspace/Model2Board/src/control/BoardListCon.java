package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardDTO;


@WebServlet("/BoardListCon.do")
public class BoardListCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		//화면에 보여질 게시글의 개수를 지정
		int pageSize= 10;
		//현재 보여지고 있는 페이지의 넘버값을 읽어드림
		String pageNum = request.getParameter("pageNum");
		//null처리
		if(pageNum == null) {
			pageNum="1";
		}
		//전체게시글의 갯수를 파악
		int count=0;
		//JSP페이지 내에서 보여질 넘버링 숫자값을 저장하는 변수 
		int number=0;
		//현재보여지고 있는 페이지 문자를 숫자로 형변환
		int currentPage = Integer.parseInt(pageNum);
		
		//전체 게시글의 갯수를 가져와야 하기에 데이터 베이스 객체 설정
		BoardDAO bdao = new BoardDAO();
		count = bdao.getAllCount();
		
		//현재 보여질 페이지 시작 번호를 설정
		int startRow = (currentPage -1)*pageSize+1;
		int endRow = currentPage * pageSize;
		
		
		//최신들 10개를 기준으로 게시글을 리턴받아주는 메소드 호출
		ArrayList<BoardDTO> arrayList = bdao.getAllBoard(startRow, endRow);
		//테이블에 표시할 번호를 지정
		number = count - (currentPage-1) * pageSize;
		
		//BoardUpdateProcCon에서 추가->request.setAttribute("msg", "수정이 완료 되었습니다!");
		//----------------수정삭제시 비밀번호가 틀렸다면-----------------------------
		String msg =(String) request.getAttribute("msg");
		
		
//------BoardList.jsp쪽으로 request객체에 담아서 넘겨줌-------------------------------------------
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("number", number);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("arrayList", arrayList);
		//----------------수정삭제시 비밀번호가 틀렸다면-----------------------------
		request.setAttribute("msg", msg);
		
		
		//BoardList.jsp - 넘기기
		RequestDispatcher dis = request.getRequestDispatcher("BoardList.jsp");
		dis.forward(request, response);
	
	}

}
