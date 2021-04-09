package board;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardVO {
	private int id;
	private String btype;
	private String author;
	private String title;
	private String context;
	private Date create_date;
	private Date update_date;
	private int view_cnt;
	private int like_cnt;
	private int dislike_cnt;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBtype() {
		return btype;
	}
	
	public void setBtype(String btype) {
		this.btype = btype;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContext() {
		return context;
	}
	
	public void setContext(String context) {
		this.context = context;
	}
	
	
	public Date getCreateDate() {
		return create_date;
	}
	
	public void setCreateDate(Date create_date) {
		this.create_date = create_date;
	}
	
	public Date getUpdateDate() {
		return update_date;
	}
	
	public void setUpdateDate(Date update_date) {
		this.update_date = update_date;
	}
	
	public int getViewCnt() {
		return view_cnt;
	}
	
	public void setViewCnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	
	public int getLikeCnt() {
		return like_cnt;
	}
	
	public void setLikeCnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}
	
	public int getDislikeCnt() {
		return dislike_cnt;
	}
	
	public void setDislikeCnt(int dislike_cnt) {
		this.dislike_cnt = dislike_cnt;
	}
	
	public void setRecord(ResultSet record) throws SQLException {
		this.id = record.getInt("id");
		this.btype = record.getString("btype");
		this.author = record.getString("author");
		this.title = record.getString("title");
		this.context = record.getString("context");
		this.create_date = record.getDate("create_date");
		this.update_date = record.getDate("update_date");
		this.view_cnt = record.getInt("view_cnt");
		this.like_cnt = record.getInt("like_cnt");
		this.dislike_cnt = record.getInt("dislike_cnt");
	}
	
}
