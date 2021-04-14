package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.DBconnection;

public class BbsDAO {

	private Connection conn;
	private ResultSet rs;

	public BbsDAO(){
		this.conn = new DBconnection("50000", "SYSTEM", "oracle").getConnect();
		
	}

//	public BbsDAO() {
//		try {
//			String driverName = "oracle.jdbc.driver.OracleDriver";
//			String dbURL = "jdbc:oracle:thin:@localhost:50000:xe";
//			String dbID = "system";
//			String dbPassword = "oracle";
//
//			Class.forName(driverName);
//			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	// B_ID 게시글번호 함수
	public int getNext() {
		String SQL = "SELECT B_ID FROM BOARD_T ORDER BY B_ID DESC";

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

	// 현재의 시간을 가져오는 함수(B_CREATEDATE)
	public String getCreateDate() {
		
			
			String SQL = "SELECT SYSDATE FROM BOARD_T";
			// Select GETDATE();
			
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
	// 현재의 시간을 가져오는 함수(B_UPDATEEDATE)
	public String getUpdateDate() {
	
		String SQL = "SELECT SYSDATE FROM BOARD_T";
		// Select GETDATE();
		
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
	public int getB_ViewCnt() {
		return -1;
	}

	public int getB_LIKECNT() {
		return -1;
	}

	// 글작성 함수
	public int write(String b_Title, String userId, String b_Content){
		String SQL = "INSERT INTO BOARD_T VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, b_Title);
			pstmt.setString(3, userId);
			pstmt.setString(4, b_Content);
			pstmt.setString(5, getCreateDate());
			pstmt.setString(6, getUpdateDate());
			pstmt.setInt(7, getB_ViewCnt());
			pstmt.setInt(8, getB_LIKECNT());

			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	

}