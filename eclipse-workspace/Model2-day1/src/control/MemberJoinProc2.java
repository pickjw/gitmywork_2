package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDTO;

@WebServlet("/MemberJoinProc.do") //jsp 파일 form태그 action값과 같게 맵핑한다
public class MemberJoinProc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//MemberDTO 사용을 하기 위한 객체 생성
		MemberDTO mdto = new MemberDTO();
		//데이터 넣기
		mdto.setId(request.getParameter("id"));
		mdto.setPass1(request.getParameter("password"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setTel(request.getParameter("tel"));
		mdto.setAddress(request.getParameter("address"));
		
		//request 객체에 DTO클래스를 추가 
		request.setAttribute("mdto", mdto);
		RequestDispatcher dis = request.getRequestDispatcher("MemberView.jsp");
		dis.forward(request, response);			
				
				
				
				
	}

}
