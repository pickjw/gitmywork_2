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

	public BoardDAO() {
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
			if (rs.next()) {
				count = rs.getInt(1);// 전체 게시글 수 리턴
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			// 자원반납
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return count;
	}

	// 모든 화면에 보이질 데이터를 10개씩 추출해서 리턴하는 메소드

	public ArrayList<BoardDTO> getAllBoard(int startRow, int endRow) { // int start, int end //최신글 10개를 기준으로 게시글을 리턴
																		// 받아주는 소스
		// 가변길이로 데이터를 저장
		ArrayList<BoardDTO> arrayList = new ArrayList<>();
		getCon();

		try {
			// 쿼리준비
			String sql = "SELECT * FROM (SELECT A.* , Rownum Rnum FROM( SELECT * FROM board ORDER BY ref DESC , re_step asc)A)"
					+ "WHERE Rnum >= ? AND Rnum <=? ";
			// mysql
			// String sql = "SELECT * FROM board ORDER BY ref DESC , re_step asc limit ?,?";
			// 오라클 경우
			// String sql = "SELECT * FROM (SELECT A.* , Rownum Rnum FROM( SELECT * FROM
			// board ORDER BY ref DESC , re_step asc)A)" + "WHERE Rnum >= ? AND Rnum <=? ";
			// mysql
			// String sql = "SELECT board.*, @RNUM := @RNUM + 1 ROWNUM FROM board, (SELECT
			// @RNUM := 0) R ORDER BY ref DESC, re_step asc limit ?,?";
			// 쿼리를 실행 시켜주는 객체 선언
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow - 1);
			pstmt.setInt(2, endRow);
			// 쿼리를 실행 시킨 결과를 리턴해서 받아줌(오라클 테이블의 검색된 결과를 자바 객체에 저장)
			rs = pstmt.executeQuery();

			// 반목문을 사용해서 rs에 저장된 데이터를 추출해 놓아야 함
			while (rs.next()) {// 저장된 데이터 만큼까지 반복문을 돌리 겠다는 뜻
				BoardDTO bdto = new BoardDTO();// 컬럼으로 나뉘어진 데이터를 DTO클래스에 저장
				bdto.setNum(rs.getInt(1));
				bdto.setWriter(rs.getString(2));
				bdto.setEmail(rs.getString(3));
				bdto.setSubject(rs.getString(4));
				bdto.setPassword(rs.getString(5));
				bdto.setReg_date(rs.getDate(6).toString());
				bdto.setRef(rs.getInt(7));
				bdto.setRe_step(rs.getInt(8));
				bdto.setRe_level(rs.getInt(9));
				bdto.setReadcount(rs.getInt(10));
				bdto.setContent(rs.getString(11));
				// 패키징된 BoardDTO 클래스를 arrayList에 저장
				arrayList.add(bdto); // 0번지 부터 순서대로 데이터가 저장

			}

		} catch (Exception e) {
			e.printStackTrace();		
		} finally {//자원반납
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();	
			}

		}
		// 다저장된 arrayList 리턴
		return arrayList;
	}
	
	//하나의 게시글을 저장하는 메소드 호출
	public void insertBoard(BoardDTO bdto) {
		
		getCon();
		int ref = 0; //새글이기에 초기화
		int re_step = 1;//새글이기에 초기화
		int re_level = 1;//새글이기에 초기화
		try {
			//쿼리준비
			String refsql ="SELECT MAX(ref) FROM board";
			pstmt= con.prepareStatement(refsql);
			//쿼리 실행후 결과를 리턴
			rs = pstmt.executeQuery();
			//데이터가 하나라도 있다면
			if(rs.next()) {
				ref = rs.getInt(1)+1;//가장큰 값에 1을 더해줌	
			}
			//데이터를 삽임하는 쿼리
			String sql = "INSERT INTO board VALUES (board_seq.nextval, ?, ?, ?, ?,sysdate,?,?,?,0,?)";
			// 쿼리 사용하도록 설정
			pstmt = con.prepareStatement(sql);// jsp에서 쿼리를 사용하도록 설정
			// ?에값을 매핑
			pstmt.setString(1, bdto.getWriter());
			pstmt.setString(2, bdto.getEmail());
			pstmt.setString(3, bdto.getSubject());
			pstmt.setString(4, bdto.getPassword());
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_step);
			pstmt.setInt(7, re_level);
			pstmt.setString(8, bdto.getContent());
			// 쿼리를 실행하시오
			pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();		
		} finally {//자원반납
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();	
			}
		}
	
	}	
	
	//하나의 게시글을 읽어 드리는 메소드 작성
	public BoardDTO getOneBoard(int num) {
		
		getCon();
		BoardDTO bdto = null;
		
		try {
			//하나글을 읽었다는 조회수증가
			String countsql="UPDATE board SET readcount = readcount+1 WHERE num=?";
			pstmt= con.prepareStatement(countsql);
			//?//
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			//한 게시글에 대한 정보를 리턴해주는 쿼리를 작성
			String sql = "SELECT * FROM board WHERE num=?";
			pstmt = con.prepareStatement(sql);
			//?
			pstmt.setInt(1, num);
			//쿼리실행후 결과를 리턴 받아야함
			rs = pstmt.executeQuery();
			if(rs.next()) {//하나의 게시글이 존재한다면
				// 컬럼으로 나뉘어진 데이터를 DTO클래스에 저장
				bdto = new BoardDTO();
				bdto.setNum(rs.getInt(1));
				bdto.setWriter(rs.getString(2));
				bdto.setEmail(rs.getString(3));
				bdto.setSubject(rs.getString(4));
				bdto.setPassword(rs.getString(5));
				bdto.setReg_date(rs.getDate(6).toString());
				bdto.setRef(rs.getInt(7));
				bdto.setRe_step(rs.getInt(8));
				bdto.setRe_level(rs.getInt(9));
				bdto.setReadcount(rs.getInt(10));
				bdto.setContent(rs.getString(11));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {//자원반납
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return bdto;
	}
	
	//답변글을 저장하는 메소드
	public void reInsertBoard(BoardDTO bdto) {
		
		getCon();
		// 부모글 그룹과 글레벨 글스텝을 읽어 드림
		int ref = bdto.getRef(); 
		int re_step =  bdto.getRe_step();
		int re_level =  bdto.getRe_level();
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
			String sql = "INSERT INTO board VALUES (board_seq.nextval, ?, ?, ?, ?,sysdate,?,?,?,0,?)";
			// 쿼리 사용하도록 설정
			pstmt = con.prepareStatement(sql);// jsp에서 쿼리를 사용하도록 설정
			// ?에값을 매핑
			pstmt.setString(1, bdto.getWriter());
			pstmt.setString(2, bdto.getEmail());
			pstmt.setString(3, bdto.getSubject());
			pstmt.setString(4, bdto.getPassword());
			pstmt.setInt(5, ref); // 부모의 ref값을 넣어줌
			pstmt.setInt(6, re_step + 1);// 답글이기에 부모글에 1를 더해줌
			pstmt.setInt(7, re_level + 1);// 답글->부모의 re_level에 1를 더해줌
			pstmt.setString(8, bdto.getContent());
			// 쿼리를 실행하시오
			pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();		
		} finally {//자원반납
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();	
			}
		}
	
	}	
	
	//조회수를 증가 하지 않는 하나의 게시글을 리턴하는 메소드- Boardupdate용 Delete시 하나의 게시글을 리턴
	//하나의 게시글을 읽어 드리는 메소드 작성
		public BoardDTO getOneUpdateBoard(int num) {
			
			getCon();
			BoardDTO bdto = null;
			
			try {
				//한 게시글에 대한 정보를 리턴해주는 쿼리를 작성
				String sql = "SELECT * FROM board WHERE num=?";
				pstmt = con.prepareStatement(sql);
				//?
				pstmt.setInt(1, num);
				//쿼리실행후 결과를 리턴 받아야함
				rs = pstmt.executeQuery();
				if(rs.next()) {//하나의 게시글이 존재한다면
					// 컬럼으로 나뉘어진 데이터를 DTO클래스에 저장
					bdto = new BoardDTO();
					bdto.setNum(rs.getInt(1));
					bdto.setWriter(rs.getString(2));
					bdto.setEmail(rs.getString(3));
					bdto.setSubject(rs.getString(4));
					bdto.setPassword(rs.getString(5));
					bdto.setReg_date(rs.getDate(6).toString());
					bdto.setRef(rs.getInt(7));
					bdto.setRe_step(rs.getInt(8));
					bdto.setRe_level(rs.getInt(9));
					bdto.setReadcount(rs.getInt(10));
					bdto.setContent(rs.getString(11));
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {//자원반납
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					if (con != null) con.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			return bdto;
		}

		//하나의 게시글을 수정하는 메소드 
		public void updateBoard(int num, String subject, String content) {
			
			getCon();
			try {
				String sql ="UPDATE board SET subject=? , content=? WHERE num=?";
				pstmt = con.prepareStatement(sql);
				//?
				pstmt.setString(1, subject);
				pstmt.setString(2, content);
				pstmt.setInt(3, num);
				//쿼리실행
				pstmt.executeUpdate();
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {//자원반납
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
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {//자원반납
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
