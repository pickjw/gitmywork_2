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
	//get 방식이던 post방식이던 이 메소드에서 처리
	private void reqPro(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//카테고리
		String cate = request.getParameter("cate");
		String brand = request.getParameter("brand");
		
		//데이터를 저장하는 객체
		Vector<PartBean> v = null;
		
		//처음 프로그램을 시작 한다면 cate값과 brand값이 널이기에 null처리를 해줌
		if(cate==null && brand== null){
			//조회수를 기준으로 8개의 데이터를 데이터베이스로부터 가져옴
			PartDAO pdao = new PartDAO();
			//데이터 베이스에서 8개의 데이터를 불러오는 메소드 호출
			v = pdao.getPopularData();		
			request.setAttribute("msg", "인기 상품");
			request.setAttribute("gubun", "1");
		}else if(cate!=null && brand== null){
			//각각의 브랜드와 카테고리를 기준으로 전 데이터를 데이터베이스로부터 가져옴
			PartDAO pdao = new PartDAO();
			//데이터 베이스에서 8개의 데이터를 불러오는 메소드 호출
			v = pdao.getCateData(cate);
			request.setAttribute("msg", cate);
			request.setAttribute("gubun", "2");
		}else{
			//각각의 브랜드와 카테고리를 기준으로 전 데이터를 데이터베이스로부터 가져옴
			PartDAO pdao = new PartDAO();
			//데이터 베이스에서 8개의 데이터를 불러오는 메소드 호출
			v = pdao.getAllData(cate,brand);
			request.setAttribute("msg", brand);
			request.setAttribute("gubun", "2");
		}
		
		//데이터를 request객체에 담아서 화면 처리jsp쪽으로 넘겨줌
		request.setAttribute("v", v);
		request.setAttribute("center", "Center.jsp");//계속해서 바뀔 센터 값을 부여
		
		//넘겨줄 메인 Jsp설정
		RequestDispatcher dis = request.getRequestDispatcher("ShoppingMain.jsp");
		dis.forward(request, response);
		
	
	}

}
