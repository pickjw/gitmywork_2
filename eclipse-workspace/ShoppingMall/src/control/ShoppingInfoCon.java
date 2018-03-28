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
	//get ����̴� post����̴� �� �޼ҵ忡�� ó��
	private void reqPro(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//��ǰ�� �˻��ؾ� �ϱ⿡ ��ǰ�� pk�� pno�� ����
		String pno = request.getParameter("pno");
		//������ ���̽� ��ü ����
		PartDAO pdao = new PartDAO();
		//�ϳ��� ��ǰ�� �޾ƿ�
		PartBean bean = pdao.getOneData(pno);
		
		//jsp������ �ѱ�����Ͽ� request��ü�� ����
		request.setAttribute("bean", bean);
		//Center���� ��ǰ �������� ȭ������ ����
		request.setAttribute("center", "ShoppingInfo.jsp");
		
		RequestDispatcher dis =request.getRequestDispatcher("ShoppingMain.jsp");
		dis.forward(request, response);
	}
	
}










