package member;

import java.sql.*;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstat = null;
	private ResultSet res = null;
	
	private void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "web_admin";
			String password = "admin";
			
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM MEMBER_t";
			
			Statement stat = conn.createStatement();
			
			ResultSet res = stat.executeQuery(sql);
			
			res.close();
			stat.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public MemberDAO() {
		this.connect();
	}
	
	public int joinCheck(String userId) {
		pstat = null;
		res = null;
		String sql = "SELECT * FROM WHERE userId = ?";
	
	try {
		pstat = conn.prepareStatement(sql);
		pstat.setString(1, userId);
		res = pstat.executeQuery();
		
		if(res.next()) {
			return 0; // 이미 존재하는 회원
		}
		else {
			return 1; // 가입 가능한 회원 아이디
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(conn != null) {
				conn.close();
			}
			if(pstat != null) {
				pstat.close();
			}
			if(res != null) {
				res.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		return -1; // 데이터베이스 오류
	}
	
	public int join(String userId, String userPassword, String userName, String userEmail, String userPhone){
		String sql = "INSER INTO MEMBER(ID,PASS,NAME,EMAIL,PHONE,JOINDATE) VALUES(?,?,?,?,?,SYSDATE)";
		
		pstat = null;
		res = null;
		conn = null;
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, userId);
			pstat.setString(2, userPassword);
			pstat.setString(3, userName);
			pstat.setString(4, userEmail);
			pstat.setString(5, userPhone);
			return pstat.executeUpdate();		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstat != null) {
					pstat.close();
				}
				if(res != null) {
					res.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return -1; // 데이터베이스 오류
	}
	
}
