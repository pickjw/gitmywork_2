package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class RentcarDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	// 커넥션 풀을 이용한 데이터 베이스 연결
	public void getCon() {

		Boolean connect = false;

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jwdb");

			con = ds.getConnection();//
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

	// 최신순 3대의 자동차를 리턴하는 메소드
	public ArrayList<CarListBean> getSelectCar() {

		// 리턴타입을 설정
		ArrayList<CarListBean> arrayList = new ArrayList();
		getCon();

		try {
			String sql = "SELECT * FROM rentcar ORDER BY no DESC";
			pstmt = con.prepareStatement(sql);
			// 쿼리 실행후 결과를 ResultSet타입으로 리턴
			rs = pstmt.executeQuery();

			// 반복문을 돌면서 데이터를 저장
			int count = 0;
			while (rs.next()) {
				CarListBean bean = new CarListBean();
				bean.setNo(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setCategory(rs.getInt(3));
				bean.setPrice(rs.getInt(4));
				bean.setUsepeople(rs.getInt(5));
				bean.setCompany(rs.getString(6));
				bean.setImg(rs.getString(7));
				bean.setInfo(rs.getString(8));
				// arrayList에 빈클래스를 저장
				arrayList.add(bean);
				count++;
				if (count > 2)// 3대만 나오게 하기
					break;// 반복문 빠져 나가기
				// 3개만 arrayList 저장

			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
	}

	// 카테고리별 자동차를 리스트를 저장하는 메소드
	public ArrayList<CarListBean> getCategoryCar(int cate) {

		// 리턴타입을 설정
		ArrayList<CarListBean> arrayList = new ArrayList();
		// 데이터를 저장할 빈클래스 선언
		CarListBean bean = null;
		// 객체 연결
		getCon();

		try {
			// 쿼리준비
			String sql = "SELECT * FROM rentcar WHERE category=?";
			pstmt = con.prepareStatement(sql);
			// ?
			pstmt.setInt(1, cate);
			// 결과를 리턴
			rs = pstmt.executeQuery();
			// 반복문을 돌면서 데이터를 저장
			while (rs.next()) {
				// 데이터를 저장할 빈클래스 생성
				bean = new CarListBean();
				bean.setNo(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setCategory(rs.getInt(3));
				bean.setPrice(rs.getInt(4));
				bean.setUsepeople(rs.getInt(5));
				bean.setCompany(rs.getString(6));
				bean.setImg(rs.getString(7));
				bean.setInfo(rs.getString(8));
				// arrayList에 빈클래스를 저장
				arrayList.add(bean);

			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;

	}

	// 모든 차량을 검색하는 메소드
	public ArrayList<CarListBean> getAllCar() {

		// 리턴타입을 설정
		ArrayList<CarListBean> arrayList = new ArrayList();
		// 데이터를 저장할 빈클래스 선언
		CarListBean bean = null;
		// 객체 연결
		getCon();

		try {
			// 쿼리준비
			String sql = "SELECT * FROM rentcar";
			pstmt = con.prepareStatement(sql);
			// ?
			// pstmt.setInt(1, cate);
			// 결과를 리턴
			rs = pstmt.executeQuery();
			// 반복문을 돌면서 데이터를 저장
			while (rs.next()) {
				// 데이터를 저장할 빈클래스 생성
				bean = new CarListBean();
				bean.setNo(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setCategory(rs.getInt(3));
				bean.setPrice(rs.getInt(4));
				bean.setUsepeople(rs.getInt(5));
				bean.setCompany(rs.getString(6));
				bean.setImg(rs.getString(7));
				bean.setInfo(rs.getString(8));
				// arrayList에 빈클래스를 저장
				arrayList.add(bean);

			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
	}

	// 하나의 자동차 정보를 리턴하는 메소드
	public CarListBean getOneCar(int no) {

		// 리턴타입 선언
		CarListBean bean = new CarListBean();
		getCon();

		try {

			// 쿼리 준비
			String sql = "SELECT * FROM rentcar WHERE no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			// 결과를 리턴
			rs = pstmt.executeQuery();
			// 반복문을 돌면서 데이터를 저장
			if (rs.next()) {
				// 데이터를 저장할 빈클래스 생성
				// bean = new CarListBean(); //위에서 생성 선언
				bean.setNo(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setCategory(rs.getInt(3));
				bean.setPrice(rs.getInt(4));
				bean.setUsepeople(rs.getInt(5));
				bean.setCompany(rs.getString(6));
				bean.setImg(rs.getString(7));
				bean.setInfo(rs.getString(8));
				// arrayList에 빈클래스를 저장
				// arrayList.add(bean);

			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bean;

	}

	// 회원정보가 있는지를 비교
	public int getMember(String id, String pass) {

		int result = 0;
		getCon();

		try {

			String sql = "SELECT COUNT(*) FROM member WHERE id=? AND pass1=?;";
			pstmt = con.prepareStatement(sql);
			// ?
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			// 결과리턴
			rs = pstmt.executeQuery();
			// 데이터가 있다면
			if (rs.next()) {
				result = rs.getInt(1);// 0또는 1값이 저장됨
			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;

	}

	// 하나의 예약 정보를 저장하는 메소드
	public void setReserveCar(CarReserveBean bean) {

		getCon();

		try {
			String sql = "INSERT INTO carreserve VALUES(?,?,?,?,?,?,?,?,?,?) ";
			pstmt = con.prepareStatement(sql);
			// ??값을대입reserveno
			pstmt.setInt(1, bean.getReserveno());
			pstmt.setInt(2, bean.getNo());
			pstmt.setString(3, bean.getId());
			pstmt.setInt(4, bean.getQty());
			pstmt.setInt(5, bean.getDday());
			pstmt.setString(6, bean.getRday());
			pstmt.setInt(7, bean.getUsein());
			pstmt.setInt(8, bean.getUsewifi());
			pstmt.setInt(9, bean.getUsenavi());
			pstmt.setInt(10, bean.getUseseat());
			// 쿼리실행
			pstmt.executeUpdate();
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	//회원의 예약 정보를 리턴하는 메소드  
	//SELECT * FROM rentcar NATURAL JOIN carreserve WHERE NOW() < rday AND id='test11';
	public ArrayList<CarViewBean> getAllReserve(String id) {

		ArrayList<CarViewBean> arrayList = new ArrayList<>();
		CarViewBean bean = null;
		
		getCon();
		
		try {
			String sql="SELECT * FROM rentcar NATURAL JOIN carreserve WHERE NOW() < rday AND id=?";
			pstmt = con.prepareStatement(sql);
			//??
			pstmt.setString(1, id);
			//결과 리턴
			rs = pstmt.executeQuery();
			//한사람이 여러 id를 사용할수 있기에
			while(rs.next()) {//데이터가 하나라도 있다면
				bean = new CarViewBean();
				bean.setName(rs.getString(2));
				bean.setPrice(rs.getInt(4));
				bean.setImg(rs.getString(7));
				bean.setQty(rs.getInt(11));
				bean.setDday(rs.getInt(12));
				bean.setRday(rs.getString(13));
				bean.setUsein(rs.getInt(14));
				bean.setUsewifi(rs.getInt(15));
				bean.setUsenavi(rs.getInt(16));
				bean.setUseseat(rs.getInt(17));
				//ArrayList 에 저장
				arrayList.add(bean);
			}
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
		
	}
	//하나의 예약 삭제
	public void carRemoveReserve(String id, String rday) {
		
		getCon();
		
		try {
			String sql="DELETE FROM  carreserve WHERE id=? AND rday=?";
			pstmt = con.prepareStatement(sql);
			//?
			pstmt.setString(1, id);
			pstmt.setString(2, rday);
			//쿼리실행
			pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	

}
