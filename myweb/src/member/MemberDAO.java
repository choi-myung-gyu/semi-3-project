package member;

import java.sql.*;

public class MemberDAO {
	private final String table = "MEMBER_t";
	private Connection conn = null;
	private PreparedStatement pstat = null;
	
	public MemberDAO() {
		this.connect();
	}
	
	public MemberVO login(String userId, String userPassword) {
		MemberVO m = new MemberVO();
		
		String sql = "";
		sql += "SELECT * FROM " + this.table;
		sql += " WHERE userId = ?";
		sql += "	AND userPassword = ?";
		
		try {
			this.pstat = this.conn.prepareStatement(sql);
			this.pstat.setString(1, userId);
			this.pstat.setString(2, userPassword);
			
			ResultSet res = this.pstat.executeQuery();
			if(res.next()) {
				m.setRecord(res);
			}
			res.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return m;
	}
	
	private void connect() {
		try {
			Class.forName("orcle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "web_admin";
			String password = "web_admin";
			
			this.conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void close() {
		try {
			this.pstat.close();
			this.conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
