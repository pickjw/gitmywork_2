package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	// ������ ���̽� ���� ��ü
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	 /*String jdbcUrl= "jdbc:mysql://localhost:3306/bbs" ;
     String dbId="root";
     String dbPass= "hwang990";

     Class.forName( "com.mysql.jdbc.Driver");
     conn=DriverManager.getConnection(jdbcUrl,dbId ,dbPass );*/
	
	
	//String URL = "jdbc:mysql://localhost:3306/[database_name]?useUnicode=true&characterEncoding=UTF-8";
	//한글출력/ 꺠짐 방지

	
	public UserDAO() {
		try {
			// �ڽ��� ��ǻ�Ϳ� ���� �� mysql ��Ʈ3306
			String dbURL = "jdbc:mysql://localhost:3306/jw_board_db";
			String dbID = "root";
			String dbPassword = "hwang990";
			// ����̹�ã�� mysql�����ϴ� �Ű�ü
			Class.forName( "com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(dbURL,dbID ,dbPassword );
			// ����ó��
		} catch (Exception e) {
			e.printStackTrace();// ����Ȯ��
		}
	}

	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM user_db WHERE userID = ? ";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(userPassword)) {
					return 1;// �α��� ����
				}	
				 else 
					return 0; // ��й�ȣ ����ġ
			}
			return -1;// ���̵� ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;// �����ͺ��̽� ����
	}
	//join�Լ�����
	public int join(User user) {
		String SQL = "INSERT INTO user_db VALUES (?, ? ,? ,? ,? )";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return -1;//�����ͺ��̽� ����
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


