package model;

public class MemberDTO {
	
	private String userId;
	private String userPassword;
	private String userName;
	
	//생성자 및 매개변수,toString(), getter,setter
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String userId, String userPassword, String userName) {
		//super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "MemberDTO [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
