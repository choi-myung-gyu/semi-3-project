package bbs;

import java.security.Timestamp;
import java.sql.Date;

public class Bbs {
	private int num;
	private String userId;
	private String title;
	private String passWd;
	private String createDate;
	private int viewCnt;
	
	private int ref;
	private int re_Step;
	private int re_Level;
	private String content;
	private String fileName;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_Step() {
		return re_Step;
	}
	public void setRe_Step(int re_Step) {
		this.re_Step = re_Step;
	}
	public int getRe_Level() {
		return re_Level;
	}
	public void setRe_Level(int re_Level) {
		this.re_Level = re_Level;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}