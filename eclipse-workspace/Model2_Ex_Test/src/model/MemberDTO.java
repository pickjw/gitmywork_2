package model;

import java.sql.Date;

public class MemberDTO {
	
	private String userid;
	private String userpass;
	private String username;
	private String useremail;
	private String phone;
	private String zinumber;
	private String adress1;
	private String adress2;
	private Date join_date;
	//MEMBER_PASS 
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String userid, String userpass, String username, String useremail, String phone, String zinumber,
			String adress1, String adress2, Date join_date) {
		super();
		this.userid = userid;
		this.userpass = userpass;
		this.username = username;
		this.useremail = useremail;
		this.phone = phone;
		this.zinumber = zinumber;
		this.adress1 = adress1;
		this.adress2 = adress2;
		this.join_date = join_date;
	}

	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", userpass=" + userpass + ", username=" + username + ", useremail="
				+ useremail + ", phone=" + phone + ", zinumber=" + zinumber + ", adress1=" + adress1 + ", adress2="
				+ adress2 + ", join_date=" + join_date + "]";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZinumber() {
		return zinumber;
	}

	public void setZinumber(String zinumber) {
		this.zinumber = zinumber;
	}

	public String getAdress1() {
		return adress1;
	}

	public void setAdress1(String adress1) {
		this.adress1 = adress1;
	}

	public String getAdress2() {
		return adress2;
	}

	public void setAdress2(String adress2) {
		this.adress2 = adress2;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	
	
	
}