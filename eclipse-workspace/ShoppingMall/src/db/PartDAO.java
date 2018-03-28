package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PartDAO {


	//�������� �����Ǿ��ִ� Ŀ�ؼ� Ǯ�� �����ؼ� ������ ���̽��� ���
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	//Ŀ�ؼ� Ǯ�� �̿��� ������ ���̽� ���� ���
	public void getCon(){  
		try {
			//server.xml�� ����� �����͸� �о�帱 �غ�
			Context initcon = new InitialContext();
			//��Ĺ�� ����� resource�� ����
			Context envcon = (Context) initcon.lookup("java:comp/env");
			//���ҽ��� �̿��Ͽ� ������ �ҽ� ��ü�� �������� ����
			DataSource ds = (DataSource) envcon.lookup("jdbc/jsp");
			//DataSource�� �̿��Ͽ� ������ ���̽��� ����
			con = ds.getConnection();   
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}

	//�α� ������ 8���� �����ϴ¸޼ҵ�
	public Vector<PartBean> getPopularData() {
		
		Vector<PartBean> v = new Vector<>();//��Ŭ�������� ������ ��ü - �ڽ�
		PartBean bean=null; // ���� �÷��� �����͸� �������ִ� ��ü -����
		
		//������ ���̽�����
		getCon();		
		try {
			//3.sql ������ �ۼ��� ��ü ����
			String sql ="select * from part order by count desc";
			pstmt = con.prepareStatement(sql);//������ ����Ҽ� �ֵ��� ���
			//4.���� ������ �������
			rs = pstmt.executeQuery();
			//�ݺ����� ���ؼ� �÷� �����͸� bean�� ������ ���Ϳ� �ٽ� ����
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

	
	//�ϳ��� ��ǰ ������ �����ϴ� �޼ҵ�
	public PartBean getOneData(String pno) {
		
		PartBean bean=null; // ���� �÷��� �����͸� �������ִ� ��ü -����		
		//������ ���̽�����
		getCon();		
		try {
			//��ȸ�� ����
			String countsql = "update part set count=count+1 where pno=?";
			pstmt = con.prepareStatement(countsql);//������ ����Ҽ� �ֵ��� ���
			pstmt.setString(1, pno);
			pstmt.executeUpdate();
			//////////////////////////////////////////////////////////
			//3.sql ������ �ۼ��� ��ü ����
			String sql ="select * from part where pno=?";
			pstmt = con.prepareStatement(sql);//������ ����Ҽ� �ֵ��� ���
			pstmt.setString(1, pno);
			//4.���� ������ �������
			rs = pstmt.executeQuery();
			//�ݺ����� ���ؼ� �÷� �����͸� bean�� ������ ���Ϳ� �ٽ� ����
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

	
	//�귣�庰 ��� ��ǰ�� �����ϴ� �޼ҵ�
	public Vector<PartBean> getAllData(String cate, String brand) {
		Vector<PartBean> v = new Vector<>();//��Ŭ�������� ������ ��ü - �ڽ�
		PartBean bean=null; // ���� �÷��� �����͸� �������ִ� ��ü -����
		
		//������ ���̽�����
		getCon();		
		try {
			//3.sql ������ �ۼ��� ��ü ����
			String sql ="select * from part where cate=? and brand=?";
			pstmt = con.prepareStatement(sql);//������ ����Ҽ� �ֵ��� ���
			pstmt.setString(1, cate);
			pstmt.setString(2, brand);
			//4.���� ������ �������
			rs = pstmt.executeQuery();
			//�ݺ����� ���ؼ� �÷� �����͸� bean�� ������ ���Ϳ� �ٽ� ����
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
		Vector<PartBean> v = new Vector<>();//��Ŭ�������� ������ ��ü - �ڽ�
		PartBean bean=null; // ���� �÷��� �����͸� �������ִ� ��ü -����
		
		//������ ���̽�����
		getCon();		
		try {
			//3.sql ������ �ۼ��� ��ü ����
			String sql ="select * from part where cate=?";
			pstmt = con.prepareStatement(sql);//������ ����Ҽ� �ֵ��� ���
			pstmt.setString(1, cate);
			
			//4.���� ������ �������
			rs = pstmt.executeQuery();
			//�ݺ����� ���ؼ� �÷� �����͸� bean�� ������ ���Ϳ� �ٽ� ����
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









