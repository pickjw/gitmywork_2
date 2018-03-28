package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {

	// 초기설정
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public UserDAO() {
		// TODO Auto-generated constructor stub
		
		Boolean connect = false;
	
		try {
			// mysql 포트번호 3306
			String dbURL = "jdbc:mysql://localhost:3306/jw_board_db";
			String dbID = "jwboard";
			String dbPassword = "jw123";
			// mysql드라이버 연결 매개체
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbURL, dbID, dbPassword);
			connect = true;
			if (connect) {
				System.out.println("연결oo");
			} else {
				System.out.println("연결x");
			
			}
			
				// 예외처리
			} catch (Exception e) {
				e.printStackTrace();// 예외처리
		
		}
	}

	public ArrayList<User> getSearch(String userName) {
		
		// 리턴타입을 설정
		ArrayList<User> userList = new ArrayList<User>();

		try {
			// 쿼리준비
			String sql = "SELECT * FROM user_ajax WHERE userName LIKE ?";
			pstmt = con.prepareStatement(sql);
			// ?값 대입
			pstmt.setString(1, "%" + userName + "%");
			// 결과리턴 및 쿼리 실행
			rs = pstmt.executeQuery();
			// 반복문을 돌면서 데이터 저장
			while (rs.next()) {// 데이터가 하나라도 있다면
				User user = new User();
				user.setUserName(rs.getString(1));
				user.setUserAge(rs.getInt(2));
				user.setUserGender(rs.getString(3));
				user.setUserEmail(rs.getString(4));
				// userList 에 저장
				userList.add(user);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userList;

	}
	
	public int getResister(User user) {
		
		try {
			// 쿼리준비
			String sql = "INSERT INTO user_ajax VALUES (?,?,?,?) ";
			pstmt = con.prepareStatement(sql);
			// ?값 대입
			pstmt.setString(1, user.getUserName());
			pstmt.setInt(2, user.getUserAge());
			pstmt.setString(3, user.getUserGender());
			pstmt.setString(4, user.getUserEmail());
			
			// 결과리턴 및 쿼리 실행
			return pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
		
		
	}

}