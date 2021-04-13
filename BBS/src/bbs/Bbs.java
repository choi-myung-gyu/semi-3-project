package bbs;

import java.security.Timestamp;
import java.sql.Date;

public class Bbs {
	private int b_Id;
	private String b_Title;
	private String userId;
	private String b_Content;
	private Timestamp b_CreateDate;
	private Timestamp b_UpdateDate;
	private int b_ViewCnt;
	private int B_LikeCnt;
	public int getB_Id() {
		return b_Id;
	}
	public void setB_Id(int b_Id) {
		this.b_Id = b_Id;
	}
	public String getB_Title() {
		return b_Title;
	}
	public void setB_Title(String b_Title) {
		this.b_Title = b_Title;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getB_Content() {
		return b_Content;
	}
	public void setB_Content(String b_Content) {
		this.b_Content = b_Content;
	}
	public Timestamp getB_CreateDate() {
		return b_CreateDate;
	}
	public void setB_CreateDate(Timestamp b_CreateDate) {
		this.b_CreateDate = b_CreateDate;
	}
	public Timestamp getB_UpdateDate() {
		return b_UpdateDate;
	}
	public void setB_UpdateDate(Timestamp b_UpdateDate) {
		this.b_UpdateDate = b_UpdateDate;
	}
	public int getB_ViewCnt() {
		return b_ViewCnt;
	}
	public void setB_ViewCnt(int b_ViewCnt) {
		this.b_ViewCnt = b_ViewCnt;
	}
	public int getB_LikeCnt() {
		return B_LikeCnt;
	}
	public void setB_LikeCnt(int b_LikeCnt) {
		B_LikeCnt = b_LikeCnt;
	}
}