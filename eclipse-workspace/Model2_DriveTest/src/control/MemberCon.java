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
@WebServlet("/control_servlet/*")
public class MemberCon extends HttpServlet {
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
		if(url.indexOf("list.do") != -1) {
			System.out.println("list do 호출......");//연결확인
			
			Map<String,Object> map = new HashMap<>();
			List<MemberDTO> list = mdao.getMemberList();//리스트 린턴
			map.put("list", list);//맵에 자료 저장
			System.out.println("map.put(\"list\", list);연결확인"+list);//연결확인
			map.put("count", list.size());
//~~~~~~~~~~Member_list.jsp로 보내기~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			request.setAttribute("map", map);
			//RequestDispatcher dis = request.getRequestDispatcher("/Member_list.jsp");
			RequestDispatcher dis = request.getRequestDispatcher("/Member_list2.jsp");
			dis.forward(request, response);
			System.out.println("Member_list.jsp 최종확인");//연결확인
			
			
		}else if(url.indexOf("join.do") != -1) {
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
			
		}else if(url.indexOf("view.do") != -1) {
			String userid = request.getParameter("userid");
			System.out.println("클릭한 ID......"+userid);//연결확인
			
			MemberDTO mdto = mdao.getMemberDetail(userid);
//~~~~~~~~~~Member_view.jsp로 보내기~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			request.setAttribute("mdto", mdto);
			RequestDispatcher dis = request.getRequestDispatcher("/Member_view.jsp");
			dis.forward(request, response);
				
		}else if(url.indexOf("update.do") != -1) {
			String userid = request.getParameter("userid");
			String userpass = request.getParameter("userpass");
			String username = request.getParameter("username");
			String useremail = request.getParameter("useremail");
			String phone = request.getParameter("phone");			
			MemberDTO mdto = new MemberDTO();
			mdto.setUserid(userid);
			mdto.setUserpass(userpass);
			mdto.setUsername(username);
			mdto.setUseremail(useremail);
			mdto.setPhone(phone);
			mdao.getUpdate(mdto);
//~~~~~~~~~~Member.jsp로 보내기~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			response.sendRedirect(context+"/Member.jsp");
			
		}else if(url.indexOf("delete.do") != -1) {
			String userid = request.getParameter("userid");
			mdao.getDelete(userid);
		}
		
		
		
	}	
}
