package model;

import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.PreparedStatement;

import java.sql.Connection;

public class MemberDAO {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	// 커넥션 풀을 이용한 데이터 베이스 연결
	public void getCon() {

		Boolean connect = false;// 연결확인

		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");

			con = ds.getConnection();
			connect = true;// 연결확인

		} catch (Exception e) {
			connect = false;// 연결확인
			e.printStackTrace();
		}

		if (connect) {
			System.out.println("연결o");
		} else {
			System.out.println("연결x");
		}
	}

	public String getLoginCheck (String userId, String userPassword) {
		
		getCon();
		String userName= null;
		try {
			String sql="SELECT username FROM mvc_member WHERE userid=? and userpassword=?";
			pstmt = con.prepareStatement(sql);
			//? 입력
			pstmt.setString(1, userId);
			pstmt.setString(2, userPassword);
			//결과값 리턴 쿼리 
			rs = pstmt.executeQuery();
			if (rs.next()) { //데이터가 있다면 (로그인 성공)
				userName = rs.getString("userName");//이름저장	
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return userName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
