package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.PartBean;
import db.PartDAO;


@WebServlet("/shoppingmain.do")
public class ShoppingMainCon extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}
	//get ����̴� post����̴� �� �޼ҵ忡�� ó��
	private void reqPro(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//ī�װ�
		String cate = request.getParameter("cate");
		String brand = request.getParameter("brand");
		
		//�����͸� �����ϴ� ��ü
		Vector<PartBean> v = null;
		
		//ó�� ���α׷��� ���� �Ѵٸ� cate���� brand���� ���̱⿡ nulló���� ����
		if(cate==null && brand== null){
			//��ȸ���� �������� 8���� �����͸� �����ͺ��̽��κ��� ������
			PartDAO pdao = new PartDAO();
			//������ ���̽����� 8���� �����͸� �ҷ����� �޼ҵ� ȣ��
			v = pdao.getPopularData();		
			request.setAttribute("msg", "�α� ��ǰ");
			request.setAttribute("gubun", "1");
		}else if(cate!=null && brand== null){
			//������ �귣��� ī�װ��� �������� �� �����͸� �����ͺ��̽��κ��� ������
			PartDAO pdao = new PartDAO();
			//������ ���̽����� 8���� �����͸� �ҷ����� �޼ҵ� ȣ��
			v = pdao.getCateData(cate);
			request.setAttribute("msg", cate);
			request.setAttribute("gubun", "2");
		}else{
			//������ �귣��� ī�װ��� �������� �� �����͸� �����ͺ��̽��κ��� ������
			PartDAO pdao = new PartDAO();
			//������ ���̽����� 8���� �����͸� �ҷ����� �޼ҵ� ȣ��
			v = pdao.getAllData(cate,brand);
			request.setAttribute("msg", brand);
			request.setAttribute("gubun", "2");
		}
		
		//�����͸� request��ü�� ��Ƽ� ȭ�� ó��jsp������ �Ѱ���
		request.setAttribute("v", v);
		request.setAttribute("center", "Center.jsp");//����ؼ� �ٲ� ���� ���� �ο�
		
		//�Ѱ��� ���� Jsp����
		RequestDispatcher dis = request.getRequestDispatcher("ShoppingMain.jsp");
		dis.forward(request, response);
		
	
	}

}
