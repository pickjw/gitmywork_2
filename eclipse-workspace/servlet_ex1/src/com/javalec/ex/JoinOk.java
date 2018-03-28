package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JoinOk")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//DAO
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;// 정보를 담을수 있는 객체
	
	//DTO= Beans
	//private String name, id, pw, phone1, phone2, phone3, gender;
	private String name;
	private String id;
	private String pw;
	private String phone1;
	private String phone2;
	private String phone3;
	private String gender;
	
	//생성자
    public JoinOk() {
        super();
        // TODO Auto-generated constructor stub  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//DTO= Beans 받아오기 ->jsp부분
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		
		//DAO부분
		try {
			//드라이버 준비
			Class.forName("com.mysql.jdbc.Driver"); //"oracle.jdbc.driver.OracleDriver"
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jw_board_db" , "jwboard" , "jw123");
			//쿼리준비
			String sql = "INSERT INTO member2 VALUES('" + name + "', '" + id + "', '" + pw + "', '" + phone1 + "', '" + phone2 + "', '"+ phone3 + "', '" + gender + "')";
			pstmt = con.prepareStatement(sql);
			//쿼리실행
			int i = pstmt.executeUpdate();
			
			if(i == 1){ //연결성공
				System.out.println("insert success");
				response.sendRedirect("joinResult.jsp");
			} else { //연결실패
				System.out.println("insert fail");
				response.sendRedirect("join.html");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {}
		}
		
	}

}
