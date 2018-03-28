package page;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dto.GuestBookDTO;
import page.dao.EmpDAO;
import page.dto.EmpDTO;

@WebServlet("/page_servlet/*") //url mapping
public class PageController extends HttpServlet {
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
		/*
		getRequestURI() : 주소 값이 컨택스패스부터 나옴(http://loaclhost(포트번호) 생략되어서 나옴) ,String
		getRequestURL() : 전체 주소값 나옴, StringBuffer
		
		String : 상수(불변성)
		StringBuffer(StringBuilder) :  상수가 아님 (가변성-원본아님) 원본이 변경됨
		=> StringBuffer를 String으로 변경 하려면 toString() 사용
		*/
		//사용자가 요청한 주소 uri 및  DAO생성
	  //String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		//방명록 리스트 dao에서 메서드 가져오기
		EmpDAO edao = new EmpDAO();
		if(uri.indexOf("list.do") != -1) {
			System.out.println("list do 호출..ok!");//연결확인
			int count = edao.getEmpCount();			//레코드 갯수 계산
			int curPage = 1; //null값일 경우 (현재 페이지 기본값)
			if(request.getParameter("curPage") != null ) {
				curPage = Integer.parseInt(request.getParameter("curPage"));
			}
			Pager pager = new Pager(count, curPage);
			int start = pager.getPageBegin();
			int end = pager.getPageEnd();
			List<EmpDTO> list = edao.getEmpList(start,end);
			//request 영역에 저장
			request.setAttribute("list", list);
			request.setAttribute("page", pager);
			System.out.println("request 저장 list 확인 o:"+list);//연결확인
			System.out.println("request 저장 page 확인 o:"+pager);//연결확인
			//포워딩 (주소는 그대로, 화면은 이동) - 방명록을 list.jsp  출력시켜라
			String page = "/page/list.jsp";  
			//String page = "request.getContextPath()+/page/list.jsp"; 
			//forward의 경우 request.getContextPath() 생략
			//RequestDispatcher dis = request.getRequestDispatcher("/page/list.jsp");
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);
			System.out.println("list.do => list.jsp 포워딩 o");//연결확인  
			
		}
		
		
		
		
		
		
		
		
		
		
	}

}
