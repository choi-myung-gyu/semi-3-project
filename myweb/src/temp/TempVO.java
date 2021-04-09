package temp;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

//CREATE TABLE temp_t(
//	    userId          VARCHAR2(20)     PRIMARY KEY,
//	    userName        VARCHAR2(20)     NOT NULL,
//	    userPassword    VARCHAR2(20)     NOT NULL,
//	    userEmail       VARCHAR2(50),
//	    userPhone       VARCHAR2(20),
//	    joinDate        DATE             DEFAULT SYSDATE
//	);

public class TempVO {
	private int userId = 0;
	private String userName = "";
	private String userPassword = "";
	private String userEmail = "";
	private String userPhone = "";
	private Date joinDate = null;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
	
	public void setRecord(ResultSet record) throws SQLException {
		this.userId = record.getInt("userId");
		this.userName = record.getString("userName");
		this.userPassword = record.getString("userPassword");
		this.userEmail = record.getString("userEmail");
		this.userPhone = record.getString("userPhone");
		this.joinDate = record.getDate("joinDate");	}
}

