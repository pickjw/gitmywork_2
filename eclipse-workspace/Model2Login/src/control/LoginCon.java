package control;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;

@WebServlet("/control_servlet/*") //호출하는곳과 받는곳이 주소가 맞아야 한다
public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;//객체 직렬화 별 상관없음
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		//request.setCharacterEncoding("UTF-8");
		//URL 과 URI 비교
		System.out.println(request.getRequestURL());//http://localhost:8080/Model2Login/LoginCon.do
		System.out.println(request.getRequestURI());///Model2Login/LoginCon.do
		String uri = request.getRequestURI();
		//문자열.indexOf("찾을내용") 내용이 있으면 인덱스, 없으면 -1
		System.out.println(uri.indexOf("LoginCon.do")); //13
		System.out.println(uri.indexOf("LogoutCon.do"));//-1
		if(uri.indexOf("LoginCon.do") != -1) {
			String userId = request.getParameter("userId");
			String userPassword = request.getParameter("userPassword");
			System.out.println(userId);//확인용
			System.out.println(userPassword);//확인용
			
			//DAO연결 및 메서드 호출
			MemberDAO mdao = new MemberDAO();
			String userName = mdao.getLoginCheck(userId, userPassword);
			String message = "";
			String page = ""; //이동할 페이지 주소
			if (userName == null) {//로그인 실패
				message= URLEncoder.encode("아이디 또는 비밀번호가 일치 하지 않습니다.","UTF-8");
				page="/SessionTestForm.jsp?message="+message;
			}else {//로그인 성공
				message = userName+"님 환영합니다.";
				//세션생성
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				session.setAttribute("message", message);
				page="/Session_Success.jsp";
			}
			System.out.println(message);//세션확인용
			response.sendRedirect(request.getContextPath()+page);
			//response.sendRedirect("Session_Success.jsp");
			
		}else if(uri.indexOf("LogoutCon.do") != -1){
			//세션변수에 저장된 값들을 제거
			HttpSession session = request.getSession();
			session.invalidate(); //세션값 초기화 클리어
			//페이지를 이동
			String message =URLEncoder.encode("로그아웃되었습니다.","UTF-8");//변수추가
			response.sendRedirect(request.getContextPath()+"/SessionTestForm.jsp?message="+message);
		}
		
		
		
	}
	
}
