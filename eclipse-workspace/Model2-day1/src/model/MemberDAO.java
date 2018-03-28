package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//mysql 데이터 베이스에 연결하고 select, insert, update, delete작업을 실행해주는 클래스 입니다.
public class MemberDAO {

	/*// mysql 접속 포트번호 3306
	String id = "jwboard";// 접속아이디
	String pass = "jw123";// 접속비밀번호
	// String url = "jdbc:mysql://localhost:3306/jw_board_db";//localhost
	String url = "jdbc:mysql://127.0.0.1:3306/jw_board_db";// 웹서버
*/
	// 오라클경우 ojdbc6를 톰캣 서버 lib에 넣어야 한다.
	// "jdbc:oracle:thin:@localhost:1521:XE"

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

     	/* 커넥션 풀로 인한 test를 위한 주석처리
		 * try {
			// 1.해당 데이터 베이스를 사용한다고 선언(패키지와 클래스를 등록=mysql)
			// 오라클의경우 class.forName("oracle.jdbc.driver.oracleDriver");

			// mysql드라이버 연결 매개체
			Class.forName("com.mysql.jdbc.Driver");

			// 2.해당데이터 베이스에 접속
			con = DriverManager.getConnection(url, id, pass);

		} catch (Exception e) {

			e.printStackTrace();
		}*/

	

	// 데이터 베이스에 한사람의 회원정보를 저장해주는 메소드
	public void insertMember(MemberDTO mbean) {

		try {

			getCon();

			// 3.접속후 쿼리 준비
			String sql = "INSERT INTO member VALUES (?,?,?,?,?,?,?,?)";

			// 쿼리 사용하도록 설정
			pstmt = con.prepareStatement(sql);// jsp에서 쿼리를 사용하도록 설정

			// ?에 맞게 데이터를 맵핑
			pstmt.setString(1, mbean.getId());
			pstmt.setString(2, mbean.getPass1());
			pstmt.setString(3, mbean.getEmail());
			pstmt.setString(4, mbean.getTel());
			pstmt.setString(5, mbean.getHobby());
			pstmt.setString(6, mbean.getJob());
			pstmt.setString(7, mbean.getAge());
			pstmt.setString(8, mbean.getInfo());

			// 4.mysql에서 쿼리를 실행하시오
			pstmt.executeUpdate(); // insert,update,delete 시 사용하는 메소드

			// 5.자원반납
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	// 모든 회원들의 정보를 리턴 해주는 메서드는 호출

	public Vector<MemberDTO> allSelectMember() {

		// 가변길이로 데이터를 저장
		Vector<MemberDTO> v = new Vector<>();

		// 무조건 데이터 베이스는 예외처리
		try {
			// 커넥션 연결
			getCon();

			// 쿼리준비
			String sql = "SELECT * FROM member";
			// 쿼리를 실행 시켜주는 객체 선언
			pstmt = con.prepareStatement(sql);
			// 쿼리를 실행 시킨 결과를 리턴해서 받아줌(오라클 테이블의 검색된 결과를 자바 객체에 저장)
			rs = pstmt.executeQuery();

			// 반목문을 사용해서 rs에 저장된 데이터를 추출해 놓아야 함
			while (rs.next()) {// 저장된 데이터 만큼까지 반복문을 돌리 겠다는 뜻
				MemberDTO bean = new MemberDTO();// 컬럼으로 나뉘어진 데이터를 빈클래스에 저장
				bean.setId(rs.getString(1));
				bean.setPass1(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setTel(rs.getString(4));
				bean.setHobby(rs.getString(5));
				bean.setJob(rs.getString(6));
				bean.setAge(rs.getString(7));
				bean.setInfo(rs.getString(8));
				// 패키징된 memberbean 클래스를 백터에 저장
				v.add(bean); // 0번지 부터 순서대로 데이터가 저장

			}

			// 자원반납
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		// 다저장된 백터를 리턴
		return v;

	}

	// 한사람에 대한 정보를 리턴하는 메서드 작성
	public MemberDTO oneSelectMember(String id) {

		// 한삶에 대한 정보만 리턴하기에 빈클래스 객체 생성
		MemberDTO bean = new MemberDTO();
		
		
		try {
			//커넥션연결
			getCon();
			//쿼리준비
			String sql ="SELECT * FROM member WHERE id=?";
			pstmt = con.prepareStatement(sql);
			// ?값을 맵핑
			pstmt.setString(1, id);
			//쿼리 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {//레코드가 있다면
				bean.setId(rs.getString(1));
				bean.setPass1(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setTel(rs.getString(4));
				bean.setHobby(rs.getString(5));
				bean.setJob(rs.getString(6));
				bean.setAge(rs.getString(7));
				bean.setInfo(rs.getString(8));
			}
			//자원반납
			con.close();
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//리턴
		return bean;
		
	}
	
	//1명의 회원의 패스워드 값을 리턴하는 메서드 작성
	public String getPass(String id) {
		
		//스트링으로 리턴을 해야 하기에 스트링 변수 선언
		
		String pass="";
		
		try {
			getCon();
			//쿼리준비
			String sql="SELECT pass1 FROM member WHERE id=?";
			
			pstmt = con.prepareStatement(sql);
			// ?값을 맵핑
			pstmt.setString(1, id);
			//쿼리 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {//레코드가 있다면
				pass=rs.getString(1);//패스워드 값이 저장된 컬럼 인덱스
			}
			//자원반납
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//결과를 리턴
		return pass;
		
	}
	
	//한회원의 정보를 수정하는 메소드
	public void updateMember(MemberDTO bean) {
		
		getCon();
		
		try {
			
			//쿼리준비
			String sql = "UPDATE member SET email=?, tel=? WHERE id=?";
			//쿼리실행 객체 선언
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getTel());
			pstmt.setString(3, bean.getId());
			
			//쿼리실행
			pstmt.executeUpdate();
			
			//자원반납
			con.close();		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	//한회원을 삭제하는 메서드 작성
	public void deleteMember (String id) {
	
		getCon();
		
		try {
			//쿼리준비
			String sql ="DELETE FROM member WHERE id=?";
			//쿼리실행 객체 선언
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			//쿼리실행
			pstmt.executeUpdate();
			//자원반납
			con.close();		
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
	
	
	
	
	
	
	
	
}
