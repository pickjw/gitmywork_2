package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberDTO;

@WebServlet("/session_servlet/*")
public class SessionCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI().toString();
		System.out.println("//주소확인용:->"+url);//주소확인용
		MemberDAO mdao = new MemberDAO();
		if(url.indexOf("login.do") != -1) {//로그인 처리- 값이 없으면 -1
			String userid = request.getParameter("userid");/*("userid") html태그 name 속성이랑 같아야함*/
			String userpass = request.getParameter("userpass");/*("userpass") html태그 name 속성이랑 같아야함*/
			System.out.println("아이디:"+userid);//연결출력 확인용
			System.out.println("패스워드:"+userpass);//연결출력 확인용
			MemberDTO mdto = new MemberDTO();
			mdto.setUserid(userid);
			mdto.setUserpass(userpass);
			String result = mdao.getLoginCheck(mdto);
			System.out.println(result);//연결출력 확인용
			String page="/ch07/session_login.jsp";//로그인 실패시 주소
			if(!result.equals("로그인 실패")) {//로그인 성공
				//세션 객체 생성 = jsp에서는 내장객체 이지만 
				//servlet에서는 직접 생성 해야함
				HttpSession session = request.getSession();
				//세션에 값 저장
				session.setAttribute("userid", userid);
				session.setAttribute("message", result);
				page="/ch07/main.jsp";
				//forward()와 차이점->주소안바뀜  sendRedirect();-> 주소가 바뀜
				response.sendRedirect(request.getContextPath()+page);
			} else { //로그인 실패
				//forward()와 차이점->주소안바뀜  sendRedirect();-> 주소가 바뀜
				response.sendRedirect(request.getContextPath()+page+"?message=error");
			}
			
		}else if (url.indexOf("logout.do") != -1) {//로그아웃처리
			//세션객체 생성
			HttpSession session = request.getSession();
			//세션을 비움(초기화)
			session.invalidate();//세션 전부 종료
			//로그인 페이지로 이동
			//forward()할때는 request.getContextPath() 포함되어 있기에 쓰면 안됨
			String page = request.getContextPath()+"/ch07/session_login.jsp?message=logout";
			response.sendRedirect(page);
		}
		
	
	
		
		
		
		
		
	}

}
