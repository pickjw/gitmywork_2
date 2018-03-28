package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;


@WebServlet("/MemberJoinProc.do")
public class MemberJoinProc extends HttpServlet {
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
		//DTO클래스 생성
		MemberDTO mdto = new MemberDTO();
		//데이터 값 받아오기
		mdto.setId(request.getParameter("id"));
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		mdto.setPass1(pass1);
		mdto.setPass2(pass2);
		mdto.setEmail(request.getParameter("email"));
		mdto.setTel(request.getParameter("tel"));
		
		//hobby 배열객체
		String [] array = request.getParameterValues("hobby");
		String data ="";
		for (String string : array) {
			data += string + ""; //하나의 스트링으로 데이터 연결	
		}
		mdto.setHobby(data);
		
		mdto.setJob(request.getParameter("job"));
		mdto.setAge(request.getParameter("age"));
		mdto.setInfo(request.getParameter("info"));
		
		//패스워드가 같을 경우에만 데이터 베이스애 저장
		if(pass1.equals(pass2)) {
			//데이터 베이스 객체 생성
			MemberDAO mdao = new MemberDAO();
			mdao.insertMember(mdto);
			//control에서 또 다른 control로 호출해주느 부분
			//MemberListCon.do->다른컨트롤로 넘겨준다
			RequestDispatcher dis = request.getRequestDispatcher("MemberListCon.do");
			dis.forward(request, response);
			
		}else{
			
			request.setAttribute("msg", "패스워드가 일치 하지 않습니다.");
			RequestDispatcher dis = request.getRequestDispatcher("LoginError.jsp");
			dis.forward(request, response);
		}
		

		
	}

}












