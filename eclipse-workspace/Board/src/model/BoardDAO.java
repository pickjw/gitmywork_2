package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	// 데이터 베이스에 접근할수 있도록 도와주는 메소드
	public void getCon() {

		Boolean connect = false;

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jwdb");

			con = ds.getConnection();
			connect = true;

		} catch (Exception e) {
			connect = false;
			e.printStackTrace();
		}

		if (connect) {
			System.out.println("연결o");
		} else {
			System.out.println("연결x");
		}
	}

	// 하나의 새로운 게시글이 넘어와서 저장 되는 메서드
	public void insertBoard(BoardBean bean) {

		getCon();

		// 빈클래스에 넘어오지 않았던 데이터들을 초기화 시켜줘야 한다.
		int ref = 0; // 글그룹 => 쿼리를 실행 시켜서 가장큰 ref값을 가져온후 +1 더한다
		int re_step = 1; // 새글이글에 = 부모글
		int re_level = 1;

		try {
			// 가장큰 ref값을 읽어오는 쿼리 준비
			String refsql = "SELECT MAX(ref) FROM board";
			// 쿼리실행
			pstmt = con.prepareStatement(refsql);
			// 쿼리 실행후 결과를 리턴
			rs = pstmt.executeQuery();
			if (rs.next()) {// 쿼리의 결과 값이 있다면
				ref = rs.getInt(1) + 1; // 최대 값에 +1을 더해서 글그룹을 설정해준다

			}

			// 실제로 게시글 전체 값을 테이블에 저장
			// 쿼리 준비
			String sql = "INSERT INTO board VALUES (?,?,?,?,?,NOW(),?,?,?,0,?)";

			// 쿼리 사용하도록 설정
			pstmt = con.prepareStatement(sql);// jsp에서 쿼리를 사용하도록 설정

			// ?에값을 매핑
			pstmt.setInt(1, bean.getNum());
			pstmt.setString(2, bean.getWriter());
			pstmt.setString(3, bean.getEmail());
			pstmt.setString(4, bean.getSubject());
			pstmt.setString(5, bean.getPassword());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, re_step);
			pstmt.setInt(8, re_level);
			pstmt.setString(9, bean.getContent());

			// 쿼리를 실행하시오
			pstmt.executeUpdate();
			// 자원반납
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// 모든 회원들의 정보를 리턴 해주는 메서드는 호출

	public ArrayList<BoardBean> getAllBoard(int start, int end) { // int start, int end //최신글 10개를 기준으로 게시글을 리턴 받아주는 소스
																	// ArrayList Vector

		// 가변길이로 데이터를 저장
		ArrayList<BoardBean> arrayList = new ArrayList<>();

		// 커넥션 연결
		getCon();

		try {
			// 쿼리준비
			String sql = "SELECT * FROM board ORDER BY ref DESC , re_step asc limit ?,?";
			// 오라클 경우
			// String sql = "SELECT * FROM (SELECT A.* , Rownum Rnum FROM( SELECT * FROM
			// board ORDER BY ref DESC , re_step asc)A)" + "WHERE Rnum > ? AND Rnum <=? ";
			// mysql
			//"SELECT * FROM board ORDER BY ref DESC , re_step asc limit ?,?";
			// String sql = "SELECT board.*, @RNUM := @RNUM + 1 ROWNUM FROM board, (SELECT
			// @RNUM := 0) R ORDER BY ref DESC, re_step asc limit ?,?";
			// 쿼리를 실행 시켜주는 객체 선언
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start - 1);
			pstmt.setInt(2, end);
			// 쿼리를 실행 시킨 결과를 리턴해서 받아줌(오라클 테이블의 검색된 결과를 자바 객체에 저장)
			rs = pstmt.executeQuery();

			// 반목문을 사용해서 rs에 저장된 데이터를 추출해 놓아야 함
			while (rs.next()) {// 저장된 데이터 만큼까지 반복문을 돌리 겠다는 뜻
				BoardBean bean = new BoardBean();// 컬럼으로 나뉘어진 데이터를 빈클래스에 저장
				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
				// 패키징된 BoardBean 클래스를 백터에 저장
				arrayList.add(bean); // 0번지 부터 순서대로 데이터가 저장

			}

			// 자원반납
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// 다저장된 arrayList 리턴
		return arrayList;

	}

	// BoardInfo 하나의 게시글을 리턴 하는 메서드
	public BoardBean getOneBoard(int num) {

		// 리턴타입 선언
		BoardBean bean = new BoardBean();

		getCon();

		try {

			// 조회수 증가 쿼리 준비
			String readsql = "UPDATE board SET readcount = readcount+1 WHERE num=?";
			pstmt = con.prepareStatement(readsql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

			// 쿼리 준비
			String sql = "SELECT * FROM board WHERE num=?";
			// 쿼리 객체 및 실행
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			// 쿼리실행후 결과를 리턴 해준다
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));

			}

			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return bean;

	}

	// 답변글이 저장되는 메서드-reWriteBoard
	public void reWriteBoard(BoardBean bean) {

		// 부모글 그룹과 글레벨 글스텝을 읽어 드림
		int ref = bean.getRef();
		int re_step = bean.getRe_step();
		int re_level = bean.getRe_level();

		// 데이터 연결
		getCon();

		try {
			// =========핵심코드============//
			// 부모 글보다 큰 re_level의 값을 전부 1씩 증가 시켜준다
			// 쿼리준비
			String levelsql = "UPDATE board SET re_level=re_level+1 WHERE ref=? AND re_level > ?";
			// 쿼리 객체 실행
			pstmt = con.prepareStatement(levelsql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, re_level);
			// 쿼리 실행
			pstmt.executeUpdate();

			// 답변글 데이터를 저장
			String sql = "INSERT INTO board VALUES (?,?,?,?,?,NOW(),?,?,?,0,?)";
			// 쿼리 사용하도록 설정
			pstmt = con.prepareStatement(sql);// jsp에서 쿼리를 사용하도록 설정
			// ?에값을 매핑
			pstmt.setInt(1, bean.getNum());
			pstmt.setString(2, bean.getWriter());
			pstmt.setString(3, bean.getEmail());
			pstmt.setString(4, bean.getSubject());
			pstmt.setString(5, bean.getPassword());
			pstmt.setInt(6, ref); // 부모의 ref값을 넣어줌
			pstmt.setInt(7, re_step + 1);// 답글이기에 부모글에 1를 더해줌
			pstmt.setInt(8, re_level + 1);// 답글->부모의 re_level에 1를 더해줌
			pstmt.setString(9, bean.getContent());
			// 쿼리를 실행하시오
			pstmt.executeUpdate();
			// 자원반납
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// Boardupdate용 Delete시 하나의 게시글을 리턴
	public BoardBean getOneUpdateBoard(int num) {

		// 리턴타입 선언
		BoardBean bean = new BoardBean();

		getCon();

		try {

			// 쿼리 준비
			String sql = "SELECT * FROM board WHERE num=?";
			// 쿼리 객체 및 실행
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			// 쿼리실행후 결과를 리턴 해준다
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));

			}

			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return bean;

	}

	// update 와 delete시 필요한 패스워드 값을 리턴해주는 메소드
	public String getPass(int num) {

		// 리턴할 변수 객체 선언
		String pass = "";// 초기값없음

		// 데이터 연결
		getCon();

		try {
			// 쿼리준비
			String sql = "SELECT password FROM board WHERE num=?";
			// 쿼리 실행할 객체 선언
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			// 패스워드값을 저장
			if (rs.next()) { // 데이터의 값이 있다면..
				pass = rs.getString(1);

			}
			// 자원반납
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pass;

	}

	// 하나의 게시글을 수정하는 메소드
	public void updateBoard(BoardBean bean) {

		getCon();

		try {
			// 쿼리준비
			String sql = "UPDATE board SET subject=? , content=? WHERE num=?";
			pstmt = con.prepareStatement(sql);

			// ?값을 대입
			pstmt.setString(1, bean.getSubject());
			pstmt.setString(2, bean.getContent());
			pstmt.setInt(3, bean.getNum());
			// 쿼리실행
			pstmt.executeUpdate();
			// 자원반납
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// 하나의 게시글을 삭제 하는 메서드
	public void deleteBoard(int num) {

		getCon();

		try {

			// 쿼리준비
			String sql = "DELETE FROM board WHERE num=?";
			pstmt = con.prepareStatement(sql);

			// ?값을 대입
			pstmt.setInt(1, num);
			// 쿼리실행
			pstmt.executeUpdate();
			// 자원반납
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// 전체 글의 갯수를 리턴 하는 메소드 작성
	public int getAllCount() {

		getCon();

		// 게시글의 전체 갯수를 저장 하는 변수
		int count = 0;

		try {
			// 쿼리준비
			String sql = "SELECT COUNT(*) FROM board";
			// 쿼리를 실행할 객체 선언
			pstmt = con.prepareStatement(sql);
			// 쿼리실행 후 결과를 리던
			rs = pstmt.executeQuery();
			if (rs.next()) { // 데이터가 있다면
				count = rs.getInt(1);// 전체 게시글 수 리턴
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		//자원반납
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return count;

	}
	
	
	
	
	
	
	
	
	
	

}
