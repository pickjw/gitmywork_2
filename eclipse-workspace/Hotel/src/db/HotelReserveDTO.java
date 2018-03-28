package db;

import java.sql.Date;

public class HotelReserveDTO {
	
	private int reserveno;
	private int no;
	private String id;
	private int dday;// 숙박기간
	private String rday;// 체크인
	private int mfood;
	private int dfood;
	private int service;
	
	
	
	public int getReserveno() {
		return reserveno;
	}
	public void setReserveno(int reserveno) {
		this.reserveno = reserveno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDday() {
		return dday;
	}
	public void setDday(int dday) {
		this.dday = dday;
	}
	public String getRday() {
		return rday;
	}
	public void setRday(String rday) {
		this.rday = rday;
	}
	public int getMfood() {
		return mfood;
	}
	public void setMfood(int mfood) {
		this.mfood = mfood;
	}
	public int getDfood() {
		return dfood;
	}
	public void setDfood(int dfood) {
		this.dfood = dfood;
	}
	public int getService() {
		return service;
	}
	public void setService(int service) {
		this.service = service;
	}
	
	
	
}
