package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.PartBean;
import db.PartDAO;


@WebServlet("/partinfo.do")
public class ShoppingInfoCon extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}
	//get 방식이던 post방식이던 이 메소드에서 처리
	private void reqPro(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//상품을 검색해야 하기에 상품의 pk인 pno를 받음
		String pno = request.getParameter("pno");
		//데이터 베이스 객체 생성
		PartDAO pdao = new PartDAO();
		//하나의 상품을 받아옴
		PartBean bean = pdao.getOneData(pno);
		
		//jsp쪽으로 넘기기위하여 request객체에 저장
		request.setAttribute("bean", bean);
		//Center값을 상품 정보보기 화면으로 변경
		request.setAttribute("center", "ShoppingInfo.jsp");
		
		RequestDispatcher dis =request.getRequestDispatcher("ShoppingMain.jsp");
		dis.forward(request, response);
	}
	
}










