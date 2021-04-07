package member;

import java.sql.*;

public class MemberDAO {
	public MemberDAO() {
		this.connect();
	}
	
	public MemberVO getUserId(String userid) {
		this.getUserId(userid);
	}
	private void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로딩 완료!");
			// 접속 정보
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "web_admin";
			String password = "damin";
			
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Oracle DB 접속 완료!");

			String sql = "SELECT * FROM member_t";
			
			Statement stat = conn.createStatement();
			
			ResultSet res = stat.executeQuery(sql);
			while(res.next()) {
				MemberVO m = new MemberVO(
						res.getString("userid"),
						res.getString("password"),
						res.getString("email"),
						res.getDate("joindate")
				);
			}
			System.out.println("SQL 질의문 실행 완료!");
			
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
