package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmpDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public EmpDAO() {
		// TODO Auto-generated constructor stub
	}

	// 커넥션 풀
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

	/*// 트렌잭션 처리
	public void getInsert() {

		getCon();
		try {
			// auto commit 해제
			con.setAutoCommit(false);
			long before = System.currentTimeMillis();//현재시간
			for (int i = 1; i <= 1000000; i++) {
				String sql = "INSERT INTO emp2 (empno, ename, deptno) VALUES (? ,? ,? )";
				pstmt = con.prepareStatement(sql);
				// ?
				pstmt.setInt(1, i);
				pstmt.setString(2, "kim" + i);
				pstmt.setInt(3, i);
				pstmt.executeUpdate();
				pstmt.close();
			}
			long after = System.currentTimeMillis();//실행후 시간
			// 수동커밋
			con.commit();
			con.setAutoCommit(true);
			System.out.println("실행시간:"+(after-before));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (con != null) con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
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
	}*/
	
	// 트렌잭션 처리
	public void getInsert_batch() {

		getCon();
		try {
			// auto commit 해제
			con.setAutoCommit(false);
			//long위로 올린다
			String sql = "INSERT INTO emp2 (empno, ename, deptno) VALUES (? ,? ,? )";
			pstmt = con.prepareStatement(sql);
			long before = System.currentTimeMillis();//현재시간
			for (int i = 1000001; i <= 2000000; i++) {
				/*String sql = "INSERT INTO emp2 (empno, ename, deptno) VALUES (? ,? ,? )";
				pstmt = con.prepareStatement(sql);*/
				// ?
				pstmt.setInt(1, i);
				pstmt.setString(2, "kim" + i);
				pstmt.setInt(3, i);
				//추가코드 addBatch();
				pstmt.addBatch();//일괄처리 작업 예약
			/*	pstmt.executeUpdate();
				pstmt.close();*/
			}
			//추가코드 executeBatch();
			pstmt.executeBatch();//일괄처리 작업 실행
			
			long after = System.currentTimeMillis();//실행후 시간
			// 수동커밋
			con.commit();
			con.setAutoCommit(true);
			System.out.println("실행시간:"+(after-before));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (con != null) con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
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
	}
	
	

}
