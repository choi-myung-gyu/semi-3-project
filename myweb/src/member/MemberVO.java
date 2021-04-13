package member;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberVO {
	private String userId = null;
	private String userPassword = null;
	private String userName = null;
	private String userEmail = null;
	private String userPhone = null;
	private Date joinDate = null;
	
	public MemberVO() {}
	
	public void setRecord(ResultSet res) throws SQLException {
		this.userId = res.getString("userId");
		this.userPassword = res.getString("userPassword");
		this.userName = res.getString("userName");
		this.userEmail = res.getString("userEmail");
		this.userPhone = res.getString("userPhone");
		this.joinDate = res.getDate("joinDate");
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", joinDate=" + joinDate + "]";
	}
	
}
