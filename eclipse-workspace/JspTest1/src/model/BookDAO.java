package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BookDAO {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public BookDAO() {
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
		
		//모든 화면에 보이질 데이터를 추출해서 리턴하는 메소드
		public ArrayList<BookDTO> getBookList () {
			
			ArrayList<BookDTO> arrayList = new  ArrayList<BookDTO>();
			getCon();
			
			try {
				String sql ="SELECT * FROM book";
				pstmt = con.prepareStatement(sql);
				rs= pstmt.executeQuery();
					while(rs.next()) {
						BookDTO bdto = new BookDTO();
						bdto.setId(rs.getInt("id"));
						bdto.setTitle(rs.getString("title"));
						bdto.setAuthor(rs.getString("author"));
						bdto.setPrice(rs.getInt("price"));
						bdto.setQty(rs.getInt("qty"));
						arrayList.add(bdto);
						/*
						기본생성자를 이용하는 방법- 매개변수 이용
						int id = rs.getInt("id");
						String title = rs.getString("title");
						String author = rs.getString("author");
						int price = rs.getInt("price");
						int qty = rs.getInt("qty");
						arrayList.add(new BookDTO(title, author, price, qty));	
						*/
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
			return arrayList;
			
		}
		
		
		
		
		
		
		
		
		
}
