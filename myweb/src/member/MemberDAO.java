package member;

import java.sql.*;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstat = null;
	private ResultSet res = null;
	
	public MemberDAO() {
		this.connect();
	}
	
	public int joinCheck(String userId) {
		
		String sql = "SELECT * FROM WHERE ID = ?";
	
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
	
	public int join(MemberVO vo){
				
		try {
			
			String sql = "INSER INTO MEMBER(ID,PASSWORD,NAME,EMAIL,PHONE,JOINDATE) VALUES(?,?,?,?,?,SYSDATE)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, vo.getUserId());
			pstat.setString(2, vo.getUserPassword());
			pstat.setString(3, vo.getUserName());
			pstat.setString(4, vo.getUserEmail());
			pstat.setString(5, vo.getUserPhone());
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
	
	private void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "web_admin";
			String password = "damin";
			
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
}
