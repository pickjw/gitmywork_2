package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import crypt.BCrypt;
import crypt.SHA256;

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
	
	//모든 화면에 보이질 데이터를 추출해서 리턴하는 메소드
	public List<MemberDTO> getMemberList () {
		
		List<MemberDTO> items = new  ArrayList<>();
		getCon();
		try {
			//String sql ="SELECT \"userId\" as userId, \"userPassword\" as userPassword, \"userName\" as userName, \"userEmail\" as userEmail, \"hpNum\" as hpNum, \"zicode\" as zicode, \"adress1\" as adress1, \"adress2\" as adress2, \"join_date\" as join_date  FROM MVC_MEMBER";
			String sql ="SELECT * FROM MEMBER_PASS";
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
				while(rs.next()) {
					MemberDTO mdto = new MemberDTO();
					mdto.setUserid(rs.getString("userid"));
					mdto.setUserpass(rs.getString("userpass"));
					mdto.setUsername(rs.getString("username"));
					mdto.setUseremail(rs.getString("useremail"));
					mdto.setPhone(rs.getString("phone"));
					mdto.setZinumber(rs.getString("zinumber"));
					mdto.setAdress1(rs.getString("adress1"));
					mdto.setAdress2(rs.getString("adress2"));
					mdto.setJoin_date(rs.getDate("join_date"));
					items.add(mdto);
					System.out.println("getMemberList 연결o");//연결확인용
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
		return items;
		
	}
	
    //join.do추가하기위한 메서드
	public void getInsert(MemberDTO mdto) {
		
		getCon();
		try {
			//sql확장시 오타방지
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO MEMBER_PASS ");
			sql.append("( userid, userpass, username, useremail, phone , zinumber, adress1, adress2 ) values ");
			sql.append(" ( ?, ?, ?, ?, ? ,?, ? ,?)");
			pstmt =con.prepareStatement(sql.toString());
			pstmt.setString(1, mdto.getUserid());
			pstmt.setString(2, mdto.getUserpass());
			pstmt.setString(3, mdto.getUsername());
			pstmt.setString(4, mdto.getUseremail());
			pstmt.setString(5, mdto.getPhone());
			pstmt.setString(6, mdto.getZinumber());
			pstmt.setString(7, mdto.getAdress1());
			pstmt.setString(8, mdto.getAdress2());
			pstmt.executeUpdate();
			System.out.println("getInsert 연결o");//연결확인용
			
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
		
	}
	//회원정보 상세 보기
	public MemberDTO getMemberDetail(String userid) {
		
		MemberDTO mdto = null;
		getCon();
		
		try {
			String sql="SELECT * FROM MEMBER_PASS WHERE userid=?";
			pstmt = con.prepareStatement(sql);
			///??
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mdto = new MemberDTO();
				mdto.setUserid(userid);
				mdto.setUserpass(rs.getString("userpass"));
				mdto.setUsername(rs.getString("username"));
				mdto.setUseremail(rs.getString("useremail"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setJoin_date(rs.getDate("join_date"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con != null) con.close();
				if(pstmt != null)pstmt.close();
				if(rs != null) rs.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return mdto;
		
	}
	
	//update.do추가하기위한 메서드
	public void getUpdate(MemberDTO mdto) {
		
		getCon();
		try {
			//sql확장시 오타방지
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE MEMBER_PASS SET ");
			sql.append(" userpass=?, username=?, useremail=?, phone=? ");
			sql.append(" WHERE userid=? ");
			pstmt =con.prepareStatement(sql.toString());
			pstmt.setString(1, mdto.getUserpass());
			pstmt.setString(2, mdto.getUsername());
			pstmt.setString(3, mdto.getUseremail());
			pstmt.setString(4, mdto.getPhone());
			pstmt.setString(5, mdto.getUserid());
			pstmt.executeUpdate();
			System.out.println("getUpdate 연결o");//연결확인용
			
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
		
	}
	
	//delete.do 삭제 메서드
	public void getDelete (String userid) {
		
		getCon();
		try {
			String sql="DELETE * FROM MEMBER_PASS WHERE userid=?";
			pstmt = con.prepareStatement(sql);
			///??
			pstmt.setString(1, userid);
			pstmt.executeUpdate();
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
	}
	//로그인 체크 메서드
	public String getLoginCheck (MemberDTO mdto) {
		
		String result ="";
		getCon();
		try {
			String sql="SELECT * FROM MEMBER_PASS WHERE userid=? AND userpass=?";
			pstmt = con.prepareStatement(sql);
			//?
			pstmt.setString(1, mdto.getUserid());
			pstmt.setString(2, mdto.getUserpass());
			rs = pstmt.executeQuery();
			if(rs.next()) { //로그인 성공
				result = rs.getString("username") +"님 환영합니다.";
			}else {//로그인 실패
				result="로그인 실패";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con != null) con.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;
	
	}
	
	//오라클 암호화를 적용한 코드
	//PACK_ENCRYPTION_DECRYPTION.FUNC_ENCRYPT('1234')
	public void getInsertCrypt (MemberDTO mdto) {
		getCon();
		try {
			//sql확장시 오타방지
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO MEMBER_PASS ");
			sql.append("( userid, userpass, username, useremail, phone , zinumber, adress1, adress2 ) values ");
			sql.append(" ( ?, PACK_ENCRYPTION_DECRYPTION.FUNC_ENCRYPT(?), ?, ?, ? ,?, ? ,?)");
			pstmt =con.prepareStatement(sql.toString());
			pstmt.setString(1, mdto.getUserid());
			pstmt.setString(2, mdto.getUserpass());
			pstmt.setString(3, mdto.getUsername());
			pstmt.setString(4, mdto.getUseremail());
			pstmt.setString(5, mdto.getPhone());
			pstmt.setString(6, mdto.getZinumber());
			pstmt.setString(7, mdto.getAdress1());
			pstmt.setString(8, mdto.getAdress2());
			pstmt.executeUpdate();
			System.out.println("getInsertCrypt 연결o");//연결확인용
			
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
		
	}
		
	//로그인 체크 암호화 오라클 메서드
		public String getLoginCheckOracle (MemberDTO mdto) {
			
			String result ="";
			getCon();
			try {
				String sql="SELECT * FROM MEMBER_PASS "
						+ " WHERE userid=? "
						+ " AND userpass=PACK_ENCRYPTION_DECRYPTION.FUNC_ENCRYPT(?)";
				pstmt = con.prepareStatement(sql);
				//?
				pstmt.setString(1, mdto.getUserid());
				pstmt.setString(2, mdto.getUserpass());
				rs = pstmt.executeQuery();
				if(rs.next()) { //로그인 성공
					result = rs.getString("username") +"님 환영합니다.";
				}else {//로그인 실패
					result="로그인 실패";
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					if(con != null) con.close();
					if(pstmt != null) pstmt.close();
					if(rs != null) pstmt.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			return result;
		
		}
	
		//join_sha.do추가하기위한 메서드
		//SHA256 방식의 암호화 처리
		public void getInsertSha256(MemberDTO mdto) {
			
			getCon();
			try {
				//sql확장시 오타방지
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT INTO MEMBER_PASS ");
				sql.append("( userid, userpass, username, useremail, phone , zinumber, adress1, adress2 ) values ");
				sql.append(" ( ?, ?, ?, ?, ? ,?, ? ,?)");
				pstmt =con.prepareStatement(sql.toString());
				pstmt.setString(1, mdto.getUserid());
				
				//SHA256 방식(스트링을 바이트 배열로 변환후 암호문 생성
				SHA256 sha = SHA256.getInstance();
				String shaPass = sha.getSha256(mdto.getUserpass().getBytes());
				//암호화된 비밀번호 입력
				pstmt.setString(2, shaPass);
				//pstmt.setString(2, mdto.getUserpass());
				pstmt.setString(3, mdto.getUsername());
				pstmt.setString(4, mdto.getUseremail());
				pstmt.setString(5, mdto.getPhone());
				pstmt.setString(6, mdto.getZinumber());
				pstmt.setString(7, mdto.getAdress1());
				pstmt.setString(8, mdto.getAdress2());
				pstmt.executeUpdate();
				System.out.println("getInsertSha256 연결o");//연결확인용
				
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
			
		}
		//SHA256 로그인 체크 메서드
		public String getLoginCheckSha256 (MemberDTO mdto) {
			
			String result ="";
			getCon();
			try {
				String sql="SELECT * FROM MEMBER_PASS WHERE userid=? AND userpass=?";
				pstmt = con.prepareStatement(sql);
				//?
				pstmt.setString(1, mdto.getUserid());
				//SHA256 방식(스트링을 바이트 배열로 변환후 암호문 생성
				SHA256 sha = SHA256.getInstance();
				String shaPass = sha.getSha256(mdto.getUserpass().getBytes());
				//암호화된 비밀번호 입력
				pstmt.setString(2, shaPass);
				
				//pstmt.setString(2, mdto.getUserpass());
				rs = pstmt.executeQuery();
				if(rs.next()) { //로그인 성공
					result = rs.getString("username") +"님 환영합니다.";
				}else {//로그인 실패
					result="로그인 실패";
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					if(con != null) con.close();
					if(pstmt != null) pstmt.close();
					if(rs != null) pstmt.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			return result;
		
		}
	
		//join_bcrypt.do추가하기위한 메서드
		//bcrypt 암호화 방식
		public void getInsertBcrypt(MemberDTO mdto) {
			
			getCon();
			try {
				//sql확장시 오타방지
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT INTO MEMBER_PASS ");
				sql.append("( userid, userpass, username, useremail, phone , zinumber, adress1, adress2 ) values ");
				sql.append(" ( ?, ?, ?, ?, ? ,?, ? ,?)");
				pstmt =con.prepareStatement(sql.toString());
				pstmt.setString(1, mdto.getUserid());
				//bcrypt 암호화 방식
				String userpass = BCrypt.hashpw(mdto.getUserpass(), BCrypt.gensalt());
				pstmt.setString(2, userpass);
	
				//pstmt.setString(2, mdto.getUserpass());
				pstmt.setString(3, mdto.getUsername());
				pstmt.setString(4, mdto.getUseremail());
				pstmt.setString(5, mdto.getPhone());
				pstmt.setString(6, mdto.getZinumber());
				pstmt.setString(7, mdto.getAdress1());
				pstmt.setString(8, mdto.getAdress2());
				pstmt.executeUpdate();
				System.out.println("getInsertBcrypt 연결o");//연결확인용
				
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
			
		}
		
		//bcrypt 암호화 방식 로그인 체크 메서드
		public String getLoginCheckBcrypt (MemberDTO mdto) {
			
			String result ="";
			getCon();
			try {
				//bcrypt 암호화 방식 쿼리문이 다름
				String sql="SELECT * FROM MEMBER_PASS WHERE userid=?";
				pstmt = con.prepareStatement(sql);
				//?
				pstmt.setString(1, mdto.getUserid());
				//pstmt.setString(2, mdto.getUserpass());
				rs = pstmt.executeQuery();
				
				//bcrypt 암호화 방식
				if(rs.next()) { //로그인 성공
					String userpass = rs.getString("userpass");
					//checkpw(평문, 암호문)
					if(BCrypt.checkpw(mdto.getUserpass(), userpass)) {
						result = rs.getString("username") +"님 환영합니다.";
					}else {//로그인 실패
						result="로그인 실패";
					}
					
				}else {
					result="로그인 실패";
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					if(con != null) con.close();
					if(pstmt != null) pstmt.close();
					if(rs != null) pstmt.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			return result;
		
		}
		
		
		
		
		

	}
