package board;

import java.sql.*;
import java.util.ArrayList;

import main.DBConnection;

public class BoardDAO {
	private final String table = "board_t";
	private Connection connection = null;
	private PreparedStatement pstat = null;
	private ResultSet result;
	
	public BoardDAO() {
//		DBConnection db_conn = new DBConnection("50000", "web_admin", "admin");
//		this.connection = db_conn.getConnect();
		this.connection = new DBConnection("50000", "adminsystem", "oracle").getConnect();
	}
	
	public BoardVO getRecord(int id) {
		BoardVO record = new BoardVO();
		
		String sql = "";
		sql += "SELECT * FROM " + this.table;
		sql += " WHERE id=?";
		
		try {
			this.setPreStatement(sql);
			this.pstat.setInt(1, id);
			result = this.pstat.executeQuery();
			if(result.next()) {
				record.setRecord(result);
			} else {
				System.out.println("조회 결과가 없습니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return record;
	}
	
//	//bbsID 게시글 번호 가져오는 함수
//		public int getNext() {
//			//String SQL = "SELECT bbsID FROM dbo.[BBS] ORDER BY bbsID DESC";
//			String SQL = "SELECT B_ID FROM board_t ORDER BY B_ID DESC";
//			
//			try {
//				PreparedStatement pstmt = connection.prepareStatement(SQL);
//				result = pstmt.executeQuery();
//				if (result.next()) {
//					return result.getInt(1) + 1;
//				}
//				return 1; // 첫번째 게시물인경우
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return -1;// 데이터베이스 오류
//		}
	
	public ArrayList<BoardVO> getAll() {
		ArrayList<BoardVO> records = new ArrayList<BoardVO>();
		
		String sql = "";
		sql += "SELECT * FROM " + this.table;
		sql += " ORDER BY id DESC";
		
		try {
			this.setPreStatement(sql);
			ResultSet result = this.pstat.executeQuery();
			while(result.next()) {
				BoardVO record = new BoardVO();
				record.setRecord(result);
				records.add(record);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return records;
	}
	
	public boolean saveData(BoardVO data) {
		boolean result = false;
		
		String sql="";
		sql += "INSERT INTO board_t(id, btype, author, title, context)";
		sql += " VALUES(board_seq.NEXTVAL,?,?,?,?)";
		
		try {
			this.pstat=this.connection.prepareStatement(sql);
			this.pstat.setString(1, data.getBtype());
			this.pstat.setString(2, data.getAuthor());
			this.pstat.setString(3, data.getTitle());
			this.pstat.setString(4, data.getContext());
			
			if(this.pstat.executeUpdate() == 1) {
				result = true;
			}
			this.pstat.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 조회수 증가
//	public void updateBoardCount(int boardNo) throws SQLException {
//	    Connection con = null;
//	    PreparedStatement pstmt = null;
//	    try {
//	        con = getConnection();
//	        String sql = "update board set boardCount = boardCount+1 where boardNo=" + boardNo;
//	        System.out.println(sql);
//	        pstmt = con.prepareStatement(sql);
//	        pstmt.executeUpdate();
//	         
//	    } catch (SQLException e) {
//	        // TODO Auto-generated catch block
//	        e.printStackTrace();
//	    } finally {
//	        closeAll(pstmt, con);
//	    }
//	}
	public void close() {
		// 모든 JDBC 관련 생성 객체 정보 close()
		try {
			this.pstat.close();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private void setPreStatement(String sql) throws SQLException {
		this.pstat = this.connection.prepareStatement(sql);
	}
}