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
	
	public int join(MemberVO vo){
		String sql = "INSERT INTO Member_t VALUES(?,?,?,?,?,SYSDATE)";
		
		pstat = null;
		res = null;
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, vo.getUserId());
			pstat.setString(2, vo.getUserPassword());
			pstat.setString(3, vo.getUserName());
			pstat.setString(4, vo.getUserEmail());
			pstat.setString(5, vo.getUserPhone());
			pstat.setDate(6, vo.getJoinDate());
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
			System.out.println("JDBC DRIVER 로딩 완료");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "web_admin";
			String password = "web_admin";
			
			this.conn = DriverManager.getConnection(url, user, password);
			System.out.println("Oracle DB 접속 완료");

			
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
