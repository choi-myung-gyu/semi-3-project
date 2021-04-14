package bbs;

import java.security.Timestamp;
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

	// B_ID 게시글번호 함수
	public int getNext() {
		String SQL = "SELECT NUM FROM BOARD_T ORDER BY NUM DESC";

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

	// 글작성 함수
	public int write(String userId, String title, String passWd, String content, String fileName, String createDate, int viewCnt, int ref, int re_Step, int re_Level ){
		String SQL = "INSERT INTO BOARD_T VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, userId);
			pstmt.setString(3, title);
			pstmt.setString(4, "123"); 
			pstmt.setString(5, getCreateDate());
			pstmt.setInt(6, viewCnt);
			pstmt.setInt(7, ref);
			pstmt.setInt(8, re_Step);
			pstmt.setInt(9, re_Level);
			pstmt.setString(10, content);
			pstmt.setString(11, fileName);
			
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	

}