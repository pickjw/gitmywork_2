package guestbook.dto;

public class GuestBookDTO {
		
	private int idx;
	private String gb_name;  
	private String gb_email; 
	private String gb_passwd; 
	private String gb_content; 
	private String post_date; 
	
	public GuestBookDTO() {
		// TODO Auto-generated constructor stub
	}

	public GuestBookDTO(int idx, String gb_name, String gb_email, String gb_passwd, String gb_content,
			String post_date) {
		super();
		this.idx = idx;
		this.gb_name = gb_name;
		this.gb_email = gb_email;
		this.gb_passwd = gb_passwd;
		this.gb_content = gb_content;
		this.post_date = post_date;
	}

	@Override
	public String toString() {
		return "GuestBookDTO [idx=" + idx + ", gb_name=" + gb_name + ", gb_email=" + gb_email + ", gb_passwd="
				+ gb_passwd + ", gb_content=" + gb_content + ", post_date=" + post_date + "]";
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getGb_name() {
		return gb_name;
	}

	public void setGb_name(String gb_name) {
		this.gb_name = gb_name;
	}

	public String getGb_email() {
		return gb_email;
	}

	public void setGb_email(String gb_email) {
		this.gb_email = gb_email;
	}

	public String getGb_passwd() {
		return gb_passwd;
	}

	public void setGb_passwd(String gb_passwd) {
		this.gb_passwd = gb_passwd;
	}

	public String getGb_content() {
		return gb_content;
	}

	public void setGb_content(String gb_content) {
		this.gb_content = gb_content;
	}

	public String getPost_date() {
		return post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}
	
	
}
