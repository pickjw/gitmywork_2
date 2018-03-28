package model;

import java.sql.Connection;//커넥션 만들기
import java.sql.DriverManager;
import java.sql.PreparedStatement;//객체
import java.sql.ResultSet;//결과물 전부 받기

import javax.naming.Context;//Context initctx = new InitialContext();
import javax.naming.InitialContext;//Context initctx = new InitialContext();
import javax.sql.DataSource;//DataSource ds = envctx.lookup("");

public class BoardDAO {
	
	Connection con; // 데이터베이스에 접근할수 있도록 설정
	PreparedStatement pstmt; // 데이터 베이스에서 쿼리를 실행시켜주는 객체
	ResultSet rs; // 데이터베이스의 테이블의 결과를 리턴받아 자바에 저장에 주는 객체

	// 데이터 베이스에 접근할수 있도록 도와주는 메소드
	public void getCon() {
		
		Boolean connect=false;
		try{
		    Context init = new InitialContext();
		    DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jwdb");
		     
		    con = ds.getConnection();
		    connect = true;
		    
		}catch(Exception e){
		   connect=false;
		   e.printStackTrace();
		}
		 
		if(connect){
		    System.out.println("연결o");
		}else{
		    System.out.println("연결x");
		}
	}
	
	//하나의 새로운 게시글이 넘어와서 저장되는 메소드
	
	public void insertBoard (BoardBean bean) {
		
		
		getCon();
		//빈클래스에 넘어오지 않았던 데이터들 초기화 해주어야 한다 
		//(11개데이터중 5개만 해서 6개가 넘어오지 못함)
		
		int ref=0;//글그룹을 의미 = 쿼리를 실행시켜서 가장큰 ref값을 가져온후 +1을 더해주면됨
		int re_step = 1;//새글이기에 = 부모글이기에
		int re_level = 1; 
		
		//예외처리
		try {
			//가장큰 ref값을 읽어 오는 쿼리 준비
			String refsql ="SELECT MAX(ref) FROM study_board_db"; //ref그룹 값중 가장 큰 값을 retrun
			//쿼리실행 객체
			pstmt = con.prepareStatement(refsql);
			//쿼리실행후 결과를 리턴받는다
			rs = pstmt.executeQuery();
			if(rs.next()) { //만약 결과 값이 있다면
				ref = rs.getInt(1)+1; //최대값에 +1를 더해서 글그룹을 설정
			}
			//실제로 게시글 전체 값을 테이블에 저장											
			String sql = "INSERT INTO study_board_db VALUES( ?, ?, ?, ?, ?, NOW(), ?, ?, 0 ,?)";//sysdate()
							//mysql 현재시간 구현 <=> oracle(sysdate)//INSERT INTO t2 VALUES (CURRENT_TIMESTAMP); //INSERT INTO t1 VALUES (NOW());
					
			//PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt = con.prepareStatement(sql);//사용하기
			//?에 맵핑하기																	 
			//기존 첫번쨰는 mysql auto_increment 설정                                                                  
			// 첫번쨰 물음표부터
			pstmt.setString(1, bean.getWriter());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getSubject());
			pstmt.setString(4, bean.getPassword());
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_step);
			pstmt.setInt(7, re_level);
			pstmt.setString(8, bean.getContent());
			//쿼리를 실행하시오
			pstmt.executeUpdate();
			//자원반납
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace(); //에러메세지 체크 (근원지를 찾아서 출력)
		}
		
		
		
		
	}

}
