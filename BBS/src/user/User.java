package user;

public class User {
	private String USERID;
	private String USERPASSWORD;
	private String USERNAME;
	private String USEREMAIL;
	private String USERPHONE;
	private String JOINDATE;
	
	public String getUserID() {
		return USERID;
	}
	public void setUserID(String userID) {
		this.USERID = userID;
	}
	public String getUserPassword() {
		return USERPASSWORD;
	}
	public void setUserPassword(String userPassword) {
		this.USERPASSWORD = userPassword;
	}
	public String getUserName() {
		return USERNAME;
	}
	public void setUserName(String userName) {
		this.USERNAME = userName;
	}
	public String getUserMail() {
		return USEREMAIL;
	}
	public void setUserMail(String userMail) {
		this.USEREMAIL = userMail;
	}
	public String getUserPhone() {
		return USERPHONE;
	}
	public void setUserPhone(String userPhone) {
		this.USERPHONE = userPhone;
	}
	public String getJoinDate() {
		return JOINDATE;
	}
	public void setJoinDate(String joinDate) {
		this.JOINDATE = joinDate;
	}
}