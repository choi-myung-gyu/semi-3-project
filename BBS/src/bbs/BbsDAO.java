package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BbsDAO {
	
	private Connection conn;
	private ResultSet rs;
	
	public BbsDAO() {
		try {
			String driverName = "oracle.jdbc.driver.OracleDriver";
			String dbURL = "jdbc:oracle:thin:@localhost:50000:xe";
			String dbID = "system";
			String dbPassword = "oracle";
			
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// B_ID 게시글번호 함수
	public int getNext() {
		String SQL = "SELECT B_ID FROM BORAD_T ORDER BY B_ID DESC";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	//현재의 시간을 가져오는 함수(B_CREATEDATE)
		public String getCreateDate() {
			String SQL = "SELECT SYSDATE FROM BOARD_T";
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					return rs.getString(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "";
		}
		
	//현재의 시간을 가져오는 함수(B_UPDATEEDATE)
			public String getUpdateDate() {
				String SQL = "SELECT SYSDATE FROM BOARD_T";
					
				try {
					PreparedStatement pstmt = conn.prepareStatement(SQL);
					rs = pstmt.executeQuery();
					if (rs.next()) {
							return rs.getString(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
					
					return "";
				}
			
			public int getB_VIEWCNT() {
				String SQL = "SELECT B_VIEWCNT FROM BORAD_T ORDER BY B_VIEWCNT DESC";
				
				try {
					PreparedStatement pstmt = conn.prepareStatement(SQL);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						return rs.getInt(1) + 1;
					}
					return 1; 
				} catch (Exception e) {
					e.printStackTrace();
				}
				return -1;
			}
			
			public int getB_LIKECNT() {
				String SQL = "SELECT B_LIKECNT FROM BORAD_T ORDER BY B_LIKECNT DESC";
				
				try {
					PreparedStatement pstmt = conn.prepareStatement(SQL);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						return rs.getInt(1) + 1;
					}
					return 1; 
				} catch (Exception e) {
					e.printStackTrace();
				}
				return -1;
			}
			
			
		
	// 글작성 함수
	public int write(String B_TITLE, String USERID, String B_CONTENT) {
		String SQL = "INSERT INTO BOARD_T VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, B_TITLE);
			pstmt.setString(3, USERID);
			pstmt.setString(4, B_CONTENT);
			pstmt.setString(5, getCreateDate());
			pstmt.setString(6, getUpdateDate());
			pstmt.setInt(7, getB_VIEWCNT());
			pstmt.setInt(8, getB_LIKECNT());

			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; 
	}
}