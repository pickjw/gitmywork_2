package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;

//servle mapping : url과 severlet을 연결시키는 코드
@WebServlet("/control_servlet2/*")
public class MemberCon2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//사용자가 요청한 주소
		String url = request.getRequestURI().toString();
		//컨텍스트 패스(웹프로젝트의 식별자)
		String context = request.getContextPath();
		MemberDAO mdao = new MemberDAO();
		//A.indexOf(B) A의 내용중에서 B가 포함된 인텍스 값	
		if(url.indexOf("join.do") != -1) {
			System.out.println("join do 호출......");//연결확인
			String userid = request.getParameter("userid");
			String userpass = request.getParameter("userpass");
			String username = request.getParameter("username");
			String useremail = request.getParameter("useremail");
			String phone = request.getParameter("phone");
			String zinumber = request.getParameter("zinumber");
			String adress1 = request.getParameter("adress1");
			String adress2 = request.getParameter("adress2");
			MemberDTO mdto = new MemberDTO();
			mdto.setUserid(userid);
			mdto.setUserpass(userpass);
			mdto.setUsername(username);
			mdto.setUseremail(useremail);
			mdto.setPhone(phone);
			mdto.setZinumber(zinumber);
			mdto.setAdress1(adress1);
			mdto.setAdress2(adress2);
			mdao.getInsert(mdto);
		}else if(url.indexOf("login.do") != -1) {
			String userid = request.getParameter("userid");
			String userpass = request.getParameter("userpass");
			System.out.println("아이디:"+userid);//연결출력 확인용
			System.out.println("패스워드:"+userpass);//연결출력 확인용
			MemberDTO mdto = new MemberDTO();
			mdto.setUserid(userid);
			mdto.setUserpass(userpass);
			String result = mdao.getLoginCheck(mdto);
			System.out.println(result);//연결출력 확인용
//~~~~~~~~~~~~~~~~~~~~request 객체에 담기~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			String page ="/Login_result.jsp";
			request.setAttribute("result", result);
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);
		}else if(url.indexOf("join_oracle_secret.do") != -1) {
			System.out.println("join_oracle_secret.do 호출......");//연결확인
			String userid = request.getParameter("userid");
			String userpass = request.getParameter("userpass");
			String username = request.getParameter("username");
			String useremail = request.getParameter("useremail");
			String phone = request.getParameter("phone");
			String zinumber = request.getParameter("zinumber");
			String adress1 = request.getParameter("adress1");
			String adress2 = request.getParameter("adress2");
			MemberDTO mdto = new MemberDTO();
			mdto.setUserid(userid);
			mdto.setUserpass(userpass);
			mdto.setUsername(username);
			mdto.setUseremail(useremail);
			mdto.setPhone(phone);
			mdto.setZinumber(zinumber);
			mdto.setAdress1(adress1);
			mdto.setAdress2(adress2);
			mdao.getInsertCrypt(mdto);
		}else if(url.indexOf("login_oracle_secret") != -1) {
			String userid = request.getParameter("userid");
			String userpass = request.getParameter("userpass");
			System.out.println("아이디:"+userid);//연결출력 확인용
			System.out.println("패스워드:"+userpass);//연결출력 확인용
			MemberDTO mdto = new MemberDTO();
			mdto.setUserid(userid);
			mdto.setUserpass(userpass);
			String result = mdao.getLoginCheckOracle(mdto);
			System.out.println(result);//연결출력 확인용
//~~~~~~~~~~~~~~~~~~~~request 객체에 담기~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			String page ="/Login_result.jsp";
			request.setAttribute("result", result);
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);
		}else if(url.indexOf("join_sha.do") != -1) {
			System.out.println("join_sha do 호출......");//연결확인
			String userid = request.getParameter("userid");
			String userpass = request.getParameter("userpass");
			String username = request.getParameter("username");
			String useremail = request.getParameter("useremail");
			String phone = request.getParameter("phone");
			String zinumber = request.getParameter("zinumber");
			String adress1 = request.getParameter("adress1");
			String adress2 = request.getParameter("adress2");
			MemberDTO mdto = new MemberDTO();
			mdto.setUserid(userid);
			mdto.setUserpass(userpass);
			mdto.setUsername(username);
			mdto.setUseremail(useremail);
			mdto.setPhone(phone);
			mdto.setZinumber(zinumber);
			mdto.setAdress1(adress1);
			mdto.setAdress2(adress2);
			mdao.getInsertSha256(mdto);
		}else if(url.indexOf("login_sha.do") != -1) {
			String userid = request.getParameter("userid");
			String userpass = request.getParameter("userpass");
			System.out.println("아이디:"+userid);//연결출력 확인용
			System.out.println("패스워드:"+userpass);//연결출력 확인용
			MemberDTO mdto = new MemberDTO();
			mdto.setUserid(userid);
			mdto.setUserpass(userpass);
			String result = mdao.getLoginCheckSha256(mdto);
			System.out.println(result);//연결출력 확인용
//~~~~~~~~~~~~~~~~~~~~request 객체에 담기~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			String page ="/Login_result.jsp";
			request.setAttribute("result", result);
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);  
		}else if(url.indexOf("join_bcrypt.do") != -1) {
			System.out.println("join_bcrypt do 호출......");//연결확인
			String userid = request.getParameter("userid");
			String userpass = request.getParameter("userpass");
			String username = request.getParameter("username");
			String useremail = request.getParameter("useremail");
			String phone = request.getParameter("phone");
			String zinumber = request.getParameter("zinumber");
			String adress1 = request.getParameter("adress1");
			String adress2 = request.getParameter("adress2");
			MemberDTO mdto = new MemberDTO();
			mdto.setUserid(userid);
			mdto.setUserpass(userpass);
			mdto.setUsername(username);
			mdto.setUseremail(useremail);
			mdto.setPhone(phone);
			mdto.setZinumber(zinumber);
			mdto.setAdress1(adress1);
			mdto.setAdress2(adress2);
			mdao.getInsertBcrypt(mdto); 
		}else if(url.indexOf("login_bcrypt.do") != -1) {
			String userid = request.getParameter("userid");
			String userpass = request.getParameter("userpass");
			System.out.println("아이디:"+userid);//연결출력 확인용
			System.out.println("패스워드:"+userpass);//연결출력 확인용
			MemberDTO mdto = new MemberDTO();
			mdto.setUserid(userid);
			mdto.setUserpass(userpass);
			String result = mdao.getLoginCheckBcrypt(mdto);
			System.out.println(result);//연결출력 확인용
//~~~~~~~~~~~~~~~~~~~~request 객체에 담기~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			String page ="/Login_result.jsp";
			request.setAttribute("result", result);
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);
		
		}
		
	}	
}
