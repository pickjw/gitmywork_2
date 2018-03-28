package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PartDAO {


	//서버측에 설정되어있는 커넥션 풀에 접근해서 데이터 베이스를 사용
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	//커넥션 풀을 이용한 데이터 베이스 연결 방법
	public void getCon(){  
		try {
			//server.xml에 등록한 데이터를 읽어드릴 준비
			Context initcon = new InitialContext();
			//톰캣에 저장된 resource를 접근
			Context envcon = (Context) initcon.lookup("java:comp/env");
			//리소스를 이용하여 데이터 소스 객체에 정보들을 맵핑
			DataSource ds = (DataSource) envcon.lookup("jdbc/jsp");
			//DataSource를 이용하여 데이터 베이스에 접근
			con = ds.getConnection();   
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}

	//인기 데이터 8개를 리턴하는메소드
	public Vector<PartBean> getPopularData() {
		
		Vector<PartBean> v = new Vector<>();//빈클래스들을 저장할 객체 - 박스
		PartBean bean=null; // 여러 컬럼의 데이터를 저장해주는 객체 -가방
		
		//데이터 베이스연결
		getCon();		
		try {
			//3.sql 쿼리문 작성후 객체 생성
			String sql ="select * from part order by count desc";
			pstmt = con.prepareStatement(sql);//쿼리를 사용할수 있도록 등록
			//4.쿼리 실행후 결과리턴
			rs = pstmt.executeQuery();
			//반복문을 통해서 컬럼 데이터를 bean에 저장후 백터에 다시 저장
			while(rs.next()){
				bean = new PartBean();
				bean.setPno(rs.getString(1));
				bean.setCount(rs.getInt(2));
				bean.setPname(rs.getString(3));
				bean.setPrice(rs.getInt(4));
				bean.setInfo(rs.getString(5));
				bean.setImg1(rs.getString(6));
				bean.setImg2(rs.getString(7));
				bean.setImg3(rs.getString(8));
				bean.setCate(rs.getString(9));
				bean.setBrand(rs.getString(10));
				bean.setTemp(rs.getString(11));
				v.add(bean);
			}		
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}			
		// TODO Auto-generated method stub
		return v;
	}

	
	//하나의 상품 정보를 리턴하는 메소드
	public PartBean getOneData(String pno) {
		
		PartBean bean=null; // 여러 컬럼의 데이터를 저장해주는 객체 -가방		
		//데이터 베이스연결
		getCon();		
		try {
			//조회수 증가
			String countsql = "update part set count=count+1 where pno=?";
			pstmt = con.prepareStatement(countsql);//쿼리를 사용할수 있도록 등록
			pstmt.setString(1, pno);
			pstmt.executeUpdate();
			//////////////////////////////////////////////////////////
			//3.sql 쿼리문 작성후 객체 생성
			String sql ="select * from part where pno=?";
			pstmt = con.prepareStatement(sql);//쿼리를 사용할수 있도록 등록
			pstmt.setString(1, pno);
			//4.쿼리 실행후 결과리턴
			rs = pstmt.executeQuery();
			//반복문을 통해서 컬럼 데이터를 bean에 저장후 백터에 다시 저장
			if(rs.next()){
				bean = new PartBean();
				bean.setPno(rs.getString(1));
				bean.setCount(rs.getInt(2));
				bean.setPname(rs.getString(3));
				bean.setPrice(rs.getInt(4));
				bean.setInfo(rs.getString(5));
				bean.setImg1(rs.getString(6));
				bean.setImg2(rs.getString(7));
				bean.setImg3(rs.getString(8));
				bean.setCate(rs.getString(9));
				bean.setBrand(rs.getString(10));
				bean.setTemp(rs.getString(11));			
			}		
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}			
		// TODO Auto-generated method stub
		return bean;
	}

	
	//브랜드별 모든 상품을 리턴하는 메소드
	public Vector<PartBean> getAllData(String cate, String brand) {
		Vector<PartBean> v = new Vector<>();//빈클래스들을 저장할 객체 - 박스
		PartBean bean=null; // 여러 컬럼의 데이터를 저장해주는 객체 -가방
		
		//데이터 베이스연결
		getCon();		
		try {
			//3.sql 쿼리문 작성후 객체 생성
			String sql ="select * from part where cate=? and brand=?";
			pstmt = con.prepareStatement(sql);//쿼리를 사용할수 있도록 등록
			pstmt.setString(1, cate);
			pstmt.setString(2, brand);
			//4.쿼리 실행후 결과리턴
			rs = pstmt.executeQuery();
			//반복문을 통해서 컬럼 데이터를 bean에 저장후 백터에 다시 저장
			while(rs.next()){
				bean = new PartBean();
				bean.setPno(rs.getString(1));
				bean.setCount(rs.getInt(2));
				bean.setPname(rs.getString(3));
				bean.setPrice(rs.getInt(4));
				bean.setInfo(rs.getString(5));
				bean.setImg1(rs.getString(6));
				bean.setImg2(rs.getString(7));
				bean.setImg3(rs.getString(8));
				bean.setCate(rs.getString(9));
				bean.setBrand(rs.getString(10));
				bean.setTemp(rs.getString(11));
				v.add(bean);
			}		
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}			
		// TODO Auto-generated method stub
		return v;
	}

	public Vector<PartBean> getCateData(String cate) {
		Vector<PartBean> v = new Vector<>();//빈클래스들을 저장할 객체 - 박스
		PartBean bean=null; // 여러 컬럼의 데이터를 저장해주는 객체 -가방
		
		//데이터 베이스연결
		getCon();		
		try {
			//3.sql 쿼리문 작성후 객체 생성
			String sql ="select * from part where cate=?";
			pstmt = con.prepareStatement(sql);//쿼리를 사용할수 있도록 등록
			pstmt.setString(1, cate);
			
			//4.쿼리 실행후 결과리턴
			rs = pstmt.executeQuery();
			//반복문을 통해서 컬럼 데이터를 bean에 저장후 백터에 다시 저장
			while(rs.next()){
				bean = new PartBean();
				bean.setPno(rs.getString(1));
				bean.setCount(rs.getInt(2));
				bean.setPname(rs.getString(3));
				bean.setPrice(rs.getInt(4));
				bean.setInfo(rs.getString(5));
				bean.setImg1(rs.getString(6));
				bean.setImg2(rs.getString(7));
				bean.setImg3(rs.getString(8));
				bean.setCate(rs.getString(9));
				bean.setBrand(rs.getString(10));
				bean.setTemp(rs.getString(11));
				v.add(bean);
			}		
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}			
		// TODO Auto-generated method stub
		return v;
	}


}









