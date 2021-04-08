package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	private Connection conn; 
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String driverName = "oracle.jdbc.driver.OracleDriver";
			String dbURL = "jdbc:oracle:thin:@localhost:50000:xe";
			String dbID = "system";
			String dbPassword = "oracle";
			
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
			System.out.println("DB에 연결 되었습니다.\n");
			
		}catch(ClassNotFoundException e) {
			System.out.println("DB 드라이버 로딩 실패 :" +e.toString());
		}catch(SQLException sqle) {
			System.out.println("DB 접속실패 :"+sqle.toString());
		}catch(Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
	}
	 public int login(String userID, String userPassword) {
		 String SQL = "SELECT userPassword FROM MEMBER_T WHERE userID = ?";
		 try {
			 pstmt = conn.prepareStatement(SQL);
			 pstmt.setString(1, userID);
			 rs = pstmt.executeQuery();
			 if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					 return 1;
				 }else
					 return 0;
			 }return -1;	 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }return -2;
	 }
	 
	 public int join(User user) {
		 String SQL = "INSERT INTO USER1 VALUES (?,?,?,?,?)";
		 try {
			 pstmt = conn.prepareStatement(SQL);
			 pstmt.setString(1, user.getUserID());
			 pstmt.setString(2, user.getUserPassword());
			 pstmt.setString(3, user.getUserName());
			 pstmt.setString(4, user.getUserMail());
			 pstmt.setString(5, user.getUserPhone());
			 pstmt.setString(6, user.getJoinDate());
			 return pstmt.executeUpdate();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return -1;
	 }
 }