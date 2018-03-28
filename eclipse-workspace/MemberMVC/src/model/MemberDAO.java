package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	// 커넥션 풀을 이용한 데이터 베이스 연결
			public void getCon() {

			Boolean connect = false;//연결확인

			try {
				Context init = new InitialContext();
				DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jwdb");

				con = ds.getConnection();
				connect = true;//연결확인

			} catch (Exception e) {
				connect = false;//연결확인
				e.printStackTrace();
			} 

			if (connect) {
				System.out.println("연결o");
			} else {
				System.out.println("연결x");
			}
		}
			
			//회원 한사람에 대한 정보를 저장하는 메소드 
			public void insertMember(MemberDTO mdto) {
				
				getCon();
	
				try {
					//쿼리준비
					String sql ="INSERT INTO member VALUES (?,?,?,?,?,?,?,?)";
					pstmt = con.prepareStatement(sql);
					//?값 대입
					pstmt.setString(1, mdto.getId());
					pstmt.setString(2, mdto.getPass1());
					pstmt.setString(3, mdto.getEmail());
					pstmt.setString(4, mdto.getTel());
					pstmt.setString(5, mdto.getHobby());
					pstmt.setString(6, mdto.getJob());
					pstmt.setString(7, mdto.getAge());
					pstmt.setString(8, mdto.getInfo());
					//쿼리 실행
					pstmt.executeUpdate();
					//자원반납
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
			
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
			//모든 회원의 정보를 리턴 하는 메소드
			public  ArrayList <MemberDTO> getAllMember() {
				
				//리턴타입을 선언
				ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
				getCon();
				
				try {
					//쿼리준비
					String sql = "SELECT * FROM member";
					pstmt= con.prepareStatement(sql);
					// 결과 리턴 해줘야함(리턴값이 있어야 하기에)
					rs = pstmt.executeQuery();
					
					//반복문을 데이터 베이스에 저장해줘야함
					while(rs.next()) { //데이터가 있다면
						MemberDTO mdto = new MemberDTO();
						mdto.setId(rs.getString(1));
						mdto.setPass1(rs.getString(2));
						mdto.setEmail(rs.getString(3));
						mdto.setTel(rs.getString(4));
						mdto.setHobby(rs.getString(5));
						mdto.setJob(rs.getString(6));
						mdto.setAge(rs.getString(7));
						mdto.setInfo(rs.getString(8));
						arrayList.add(mdto);
						
					}
					//자원반납
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return arrayList; 
			}
			
			

}
