package board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import main.DBConnection;

public class BoardDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	
	private static BoardDAO instance = new BoardDAO();
			
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public BoardDAO(){
		this.connection = new DBConnection("1521", "system", "oracle").getConnect();
		
	}

	public void insertArticle(BoardVO article) throws Exception {

		ResultSet rs = null;
		
		int num = article.getNum();
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
		int number=0;
		String sql = "";
		
		try {
			if(connection==null)
				System.out.println("fail");
			else
				System.out.println("Connected");
			sql = "select max(num) from board_t";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				number = rs.getInt(1) + 1;
			}else {
				number = 1;
			}
			closeDBResources(rs, pstmt);			
			if(num!=0) {  
				sql = "update board_t set re_step=re_step+1 where ref=? and re_step>?";
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				re_step = re_step +1;
				re_level = re_level+1;
			}else {		
				ref = number;
				re_step = 0;
				re_level = 0;
			}
			closeDBResources(rs, pstmt);			
			sql="insert into board_t (num, userid, title, passwd, createdate, ";
			sql+=" ref, re_step, re_level, content, filename) values (?,?,?,?,?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, number);
            pstmt.setString(2, article.getUserid());
            pstmt.setString(3, article.getTitle());
            pstmt.setString(4, article.getPasswd());
			pstmt.setTimestamp(5, article.getCreatedate());
            pstmt.setInt(6, ref);
            pstmt.setInt(7, re_step);
            pstmt.setInt(8, re_level);
			pstmt.setString(9, article.getContent());
			pstmt.setString(10, article.getFilename());
			pstmt.executeUpdate();
			
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	public int getArticleCount() throws Exception{

		ResultSet rs = null;
		
		int x = 0;
		try {
			
			pstmt = connection.prepareStatement("select count(*) from board_t");
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				x=rs.getInt(1);
			}
			
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return x;
	}
	
	
	public List<BoardVO> getArticles(int start, int end) throws Exception{

		ResultSet rs = null;
		
		List<BoardVO> articleList = null;
		try {
			
			String sql = "SELECT * "
					+ "FROM (SELECT ROWNUM rnum, B.*"
					+ " FROM "
					+ " (SELECT * FROM board_t ORDER BY ref desc, re_step asc ) B ) ";
			sql += "WHERE rnum >= ? and rnum <= ?";
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<BoardVO>(end);
				do {
					BoardVO article = new BoardVO();
					article.setNum(rs.getInt("num"));
					article.setUserid(rs.getString("userid"));
					article.setTitle(rs.getString("title"));
					article.setPasswd(rs.getString("passwd"));
					article.setCreatedate(rs.getTimestamp("createdate"));
					article.setViewcnt(rs.getInt("viewcnt"));
					article.setRef(rs.getInt("ref"));
					article.setRe_step(rs.getInt("re_step"));
					article.setRe_level(rs.getInt("re_level"));
					article.setContent(rs.getString("content"));
					article.setFilename(rs.getString("filename"));
					articleList.add(article);
				}while(rs.next());
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return articleList;
	}
	
	public BoardVO getArticle(int num) throws Exception{

		ResultSet rs = null;
		BoardVO article = null;
		
		try {
			pstmt = connection.prepareStatement(
					"update board_t set viewcnt=viewcnt+1 where num =?");
				pstmt.setInt(1, num);
				pstmt.executeUpdate();
			
			pstmt = connection.prepareStatement(
					"select * from board_t where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article= new BoardVO();				
				article.setNum(rs.getInt("num"));
				article.setUserid(rs.getString("userid"));
				article.setTitle(rs.getString("title"));
				article.setPasswd(rs.getString("passwd"));
				article.setCreatedate(rs.getTimestamp("createdate"));
				article.setViewcnt(rs.getInt("viewcnt"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				article.setContent(rs.getString("content"));
				article.setFilename(rs.getString("filename"));
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return article;
	}
	
	public BoardVO updateGetArticle(int num) throws Exception {

		ResultSet rs = null;
		BoardVO article = null;
		
		try {
			pstmt = connection.prepareStatement(
					"select * from board_t where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setUserid(rs.getString("userid"));
				article.setTitle(rs.getString("title"));
				article.setPasswd(rs.getString("passwd"));
				article.setCreatedate(rs.getTimestamp("createdate"));
				article.setViewcnt(rs.getInt("viewcnt"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				article.setContent(rs.getString("content"));
				article.setFilename(rs.getString("filename"));
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return article;
	}
	
	public int updateArticle(BoardVO article) throws Exception{

		ResultSet rs = null;
		
		String dbpasswd = "";
		String sql = "";
		int x=-1;
		try {
			pstmt = connection.prepareStatement(
					"select passwd from board_t where num = ?");
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbpasswd = rs.getString("passwd");
				if(dbpasswd.equals(article.getPasswd())) {
					sql = "update board_t set userid=?, title=?, passwd=?";
					sql+=", content=? where num=?";
					pstmt = connection.prepareStatement(sql);
					
					pstmt.setString(1, article.getUserid());
					pstmt.setString(2, article.getTitle());
					pstmt.setString(3, article.getPasswd());
					pstmt.setString(4, article.getContent());
					pstmt.setInt(5, article.getNum());
					pstmt.executeQuery();
					x =1;
				}else {
					x= 0;
				}
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return x;
	}
	public int deleteArticle(int num, String passwd) throws Exception{

		ResultSet rs = null;
		String dbpasswd = "";
		int x = -1;
		try {
			pstmt = connection.prepareStatement(
					"select passwd from board_t where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbpasswd = rs.getString("passwd");
				if(dbpasswd.equals(passwd)) {
					pstmt = connection.prepareStatement("delete from board_t where num = ?");
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
					x = 1;	
				}else {
					x = 0;	
				}
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return x;
	}
	
	public String checkIdPw(String id) throws Exception{
		String dbpasswd = null;
		ResultSet rs = null;
		
		
		try {
			pstmt = connection.prepareStatement(
					"select passwd from login where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbpasswd = rs.getString("passwd");
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return dbpasswd;
	}
	
	public int insertLogin(LoginVO article) throws Exception {

		int result = 0;
		String sql = "";
		
		try {
			if(connection==null)
				System.out.println("fail");
			else
				System.out.println("Connected");			
			
			sql="insert into login (id, passwd, email, tel, name, reg_date)";
			sql+=" values (?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, article.getId());
            pstmt.setString(2, article.getPasswd());
            pstmt.setString(3, article.getEmail());
            pstmt.setString(4, article.getTel());
            pstmt.setString(5, article.getName());
			pstmt.setTimestamp(6, article.getReg_date());
			result = pstmt.executeUpdate();
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	
	private void closeDBResources(ResultSet rs, PreparedStatement pstmt) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void close() {
		try {
			this.pstmt.close();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}