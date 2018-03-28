package memo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.dao.MemoDAO;
import memo.dto.MemoDTO;

@WebServlet("/memo_servlet/*")
public class MemoController extends HttpServlet {
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
		//사용자가 요청한 주소
		String uri =  request.getRequestURI();
		MemoDAO mdao = new MemoDAO();
		
		if(uri.indexOf("list.do") != -1) {
			System.out.println("list do 호출..ok!");//연결확인
			//검색 옵션 + 검색 키워드
			String searchkey = request.getParameter("searchkey");
			String search = request.getParameter("search");
			List<MemoDTO> list = mdao.getListMemo(searchkey, search); //메모목록 리턴 -dao에서 메서드 가져오기 
			//request 영역에 저장
			request.setAttribute("list", list);
			System.out.println("request 저장 list확인 o:"+list);//연결확인
			//포워딩 (주소는 그대로, 화면은 이동)
			//String page = "/memo/memo_list.jsp";
			//RequestDispatcher dis = request.getRequestDispatcher("/memo_list.jsp");
			RequestDispatcher dis = request.getRequestDispatcher("/memo/memo_list.jsp");
			dis.forward(request, response);
			System.out.println("memo_list.jsp 포워딩 o");//연결확인
			
			
		}else if(uri.indexOf("insert.do") != -1) {
			System.out.println("insert do 호출..ok!");//연결확인
			//사용자가 입력한 내용을 mdto에 저장 함
			String writer = request.getParameter("writer");//제이쿼리 insert 함수의 var writer=$("#writer").val();같게 해야함
			String memo = request.getParameter("memo");
			MemoDTO mdto = new MemoDTO();
			mdto.setWriter(writer);
			mdto.setMemo(memo);
			//mdao에 레코드 저장 요청
			mdao.getInsertMemo(mdto); //메서드 가져오기
			System.out.println("DAO Insert요청 확인o");//연결확인
			
			
		}else if(uri.indexOf("view.do") != -1) {
			System.out.println("view.do 호출..ok!");//연결확인
			//사용자가 입력한 내용을 mdto에 저장 함
			int idx = Integer.parseInt(request.getParameter("idx"));
			System.out.println("글번호:"+idx);//연결확인
			MemoDTO mdto = mdao.getViewMemo(idx);  //dao에서 메서드 가져오기 
			//request 영역에 저장
			request.setAttribute("mdto", mdto);
			System.out.println("request 저장 mdto확인 o:"+mdto);//연결확인
			//포워딩 (주소는 그대로, 화면은 이동)
			//String page = "/memo/memo_view.jsp";
			//RequestDispatcher dis = request.getRequestDispatcher("/memo_view.jsp");
			RequestDispatcher dis = request.getRequestDispatcher("/memo/memo_view.jsp");
			dis.forward(request, response);
			System.out.println("memo_view.jsp 포워딩 o");//연결확인
		
			
			
		}else if(uri.indexOf("update.do") != -1) {
			System.out.println("update.do 호출..ok!");//연결확인
			//사용자가 입력한 내용을 mdto에 저장 함
			int idx = Integer.parseInt(request.getParameter("idx"));
			String writer = request.getParameter("writer");//제이쿼리 insert 함수의 var writer=$("#writer").val();같게 해야함
			String memo = request.getParameter("memo");
			MemoDTO mdto = new MemoDTO(); 
			mdto.setIdx(idx); //view.jsp hidden에서 넘어옴
			mdto.setWriter(writer);
			mdto.setMemo(memo);
			//mdao에 레코드 수정 요청
			mdao.getUpdateMemo(mdto); //메서드 가져오기
			response.sendRedirect(request.getContextPath()+"/memo/memo.jsp");
			System.out.println("DAO 레코드 수정 요청 확인o");//연결확인
	
			
		}else if(uri.indexOf("delete.do") != -1) {
			System.out.println("delete.do 호출..ok!");//연결확인
			//사용자가 입력한 내용을 mdto에 저장 함
			int idx = Integer.parseInt(request.getParameter("idx"));
			//mdao에 레코드 삭제 요청
			mdao.getDeleteMemo(idx); //메서드 가져오기
			response.sendRedirect(request.getContextPath()+"/memo/memo.jsp");
			System.out.println("DAO 레코드 삭제 요청 확인o");//연결확인
		}	
		
	}
}
