package com.javalec.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogInOk")
public class LogInOk extends HttpServlet {
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
    public LogInOk() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DTO= Beans 받아오기 ->jsp부분
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		//DAO부분
		try {
			Class.forName("com.mysql.jdbc.Driver"); //"oracle.jdbc.driver.OracleDriver"
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jw_board_db" , "jwboard" , "jw123");
			//쿼리준비
			String sql = "select * from member2 where id = '" + id + "' and pw = '" + pw + "'";
			pstmt = con.prepareStatement(sql);
			//쿼리실행
			rs =  pstmt.executeQuery();
			
			while (rs.next()) {//데이터가 있다면
				name = rs.getString("name");
				id = rs.getString("id");
				pw = rs.getString("pw");
				phone1 = rs.getString("phone1");
				phone2 = rs.getString("phone2");
				phone3 = rs.getString("phone3");
				gender = rs.getString("gender");
			}
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("name", name);
			httpSession.setAttribute("id", id);
			httpSession.setAttribute("pw", pw);
			
			response.sendRedirect("loginResult.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
