package guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.DAO.GuestBookDAO;
import guestbook.dto.GuestBookDTO;

@WebServlet("/guestbook_servlet/*")//url pattern 지정
public class GusetBookController extends HttpServlet {
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
		GuestBookDAO gdao = new GuestBookDAO();
		
		if(uri.indexOf("list.do") != -1) {
			System.out.println("list do 호출..ok!");//연결확인
			//검색옵션과 감색 키워드 가져오기
			String searchkey = request.getParameter("searchkey");
			String search = request.getParameter("search");
			//검색옵션과 검색 키워드에 기본값 할당
			if(searchkey == null) searchkey="gb_name";
			if(search == null) search="";
			System.out.println("searchkey:"+searchkey);//null확인
			System.out.println("search:"+search);//null확인
			
			
			//방명록 리스트 dao에서 메서드 가져오기
			List<GuestBookDTO> items = gdao.getList(searchkey, search); 
			System.out.println("DAO List요청 확인o");//연결확인
			//request 영역에 저장
			request.setAttribute("list", items);
			request.setAttribute("count", items.size()); //레코드 갯수(요소갯수 확인)
			request.setAttribute("searchkey", searchkey);
			request.setAttribute("search", search); 
			System.out.println("request 저장 list 확인 o:"+items);//연결확인
			System.out.println("request 저장 count 확인 o:"+items.size());//연결확인
			System.out.println("request 저장 searchkey 확인 o:"+searchkey);//연결확인
			System.out.println("request 저장 search 확인 o:"+search);//연결확인
			//포워딩 (주소는 그대로, 화면은 이동) - 방명록을 list.jsp  출력시켜라
			//String page = "/guestbook/list.jsp";  String page = "request.getContextPath()+/guestbook/list.jsp"; 
			//forward의 경우 request.getContextPath() 생략
			//RequestDispatcher dis = request.getRequestDispatcher("/list.jsp");
			RequestDispatcher dis = request.getRequestDispatcher("/guestbook/list.jsp");
			dis.forward(request, response);
			System.out.println("list.do => list.jsp 포워딩 o");//연결확인  
			
		}else if(uri.indexOf("insert.do") != -1) {
			System.out.println("insert.do 호출..ok!");//연결확인
			String gb_name = request.getParameter("gb_name");//제이쿼리 insert 함수의 var gb_name=$("#gb_name").val();같게 해야함
			String gb_email = request.getParameter("gb_email");
			String gb_passwd = request.getParameter("gb_passwd");
			String gb_content = request.getParameter("gb_content");
			GuestBookDTO gdto = new GuestBookDTO();
			gdto.setGb_name(gb_name);
			gdto.setGb_email(gb_email);
			gdto.setGb_passwd(gb_passwd);
			gdto.setGb_content(gb_content);
			//gdao에 레코드 추가 요청
			gdao.getGbInsert(gdto);; //메서드 가져오기
			System.out.println("DAO GbInsert요청 확인o");//연결확인
			String url = "/guestbook_servlet/list.do"; 
			response.sendRedirect(request.getContextPath()+url);
			System.out.println("insert.do =>list.do sendRedirect o");//연결확인  
			//String page = "/guestbook_servlet/list.do"; 
			//String page = "request.getContextPath()+/guestbook/list.jsp"; 
			//forward의 경우 request.getContextPath() 생략
			//RequestDispatcher dis = request.getRequestDispatcher("/list.do");
			/*RequestDispatcher dis = request.getRequestDispatcher("/guestbook_servlet/list.do");
			dis.forward(request, response);*/
			//System.out.println("list.do 포워딩 o");//연결확인  
			
			
		} else if(uri.indexOf("passwd_ckeck.do") != -1) {
			System.out.println("passwd_ckeck.do 호출..ok!");//연결확인
			int idx = Integer.parseInt(request.getParameter("idx"));
			String gb_passwd = request.getParameter("gb_passwd");
			System.out.println("게시물 번호 확인:" +idx);//연결확인
			System.out.println("사용자가 입력한 비번 확인:" +gb_passwd);//연결확인
			
			boolean result=gdao.getPassCheck(idx, gb_passwd);
			String url="";
			System.out.println("결과 확인:" +result);//연결확인
			if(result) {
				url="/guestbook/edit.jsp";
				//게시믈 내용을 gdto로 리턴받음
				GuestBookDTO gdto = gdao.getGbDetail(idx);
				System.out.println("DAO GbDetail요청 확인o");//연결확인
				//request 영역에 저장
				request.setAttribute("gdto", gdto);
				System.out.println("request 저장 gdto 확인 o:"+gdto);//연결확인
			}else {
				url="/guestbook_servlet/list.do";
			}
			//화면이동
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
			
		}else if(uri.indexOf("update.do") != -1) {
			System.out.println("update.do 호출..ok!");//연결확인
			int idx = Integer.parseInt(request.getParameter("idx"));//hidden 속성에서 가져온다
			String gb_name = request.getParameter("gb_name");//태그의 name속성에서 값을 가져온다
			String gb_email = request.getParameter("gb_email");
			String gb_passwd = request.getParameter("gb_passwd");
			String gb_content = request.getParameter("gb_content");
			GuestBookDTO gdto = new GuestBookDTO();
			gdto.setIdx(idx);
			gdto.setGb_name(gb_name);
			gdto.setGb_email(gb_email);
			gdto.setGb_passwd(gb_passwd);
			gdto.setGb_content(gb_content);
			//gdao에 레코드 수정 요청
			gdao.getGbUpdate(gdto);
			System.out.println("DAO GbUpdate요청 확인o");//연결확인
			String url = "/guestbook_servlet/list.do"; 
			response.sendRedirect(request.getContextPath()+url);
			System.out.println("update.do =>list.do sendRedirect o");//연결확인  
			//String page = "/guestbook_servlet/list.do"; 
			//String page = "request.getContextPath()+/guestbook/list.jsp"; 
			//forward의 경우 request.getContextPath() 생략
			//RequestDispatcher dis = request.getRequestDispatcher("/list.do");
			/*RequestDispatcher dis = request.getRequestDispatcher("/guestbook_servlet/list.do");
			dis.forward(request, response);*/
			//System.out.println("list.do 포워딩 o");//연결확인  
			
		}else if(uri.indexOf("delete.do") != -1) {
			System.out.println("delete.do 호출..ok!");//연결확인
			//삭제할 게시물 번호-form1태그의 hidden에서 넘어옴
			int idx = Integer.parseInt(request.getParameter("idx"));
			//gdao에 레코드 삭제 요청
			gdao.getGbDelete(idx);
			System.out.println("DAO GbDelete요청 확인o");//연결확인
			String url = "/guestbook_servlet/list.do"; 
			response.sendRedirect(request.getContextPath()+url);
			System.out.println("delete.do =>list.do sendRedirect o");//연결확인  
			//String page = "/guestbook_servlet/list.do"; 
			//String page = "request.getContextPath()+/guestbook/list.jsp"; 
			//forward의 경우 request.getContextPath() 생략
			//RequestDispatcher dis = request.getRequestDispatcher("/list.do");
			/*RequestDispatcher dis = request.getRequestDispatcher("/guestbook_servlet/list.do");
			dis.forward(request, response);*/
			//System.out.println("list.do 포워딩 o");//연결확인  
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
