package temp;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TempVO {
	private int id = 0;
	private String name = "";
	private Date c_date = null;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getCDate() {
		return c_date;
	}
	
	public void setCDate(Date c_date) {
		this.c_date = c_date;
	}
	
	public void setRecord(ResultSet record) throws SQLException {
		this.id = record.getInt("id");
		this.name = record.getString("name");
		this.c_date = record.getDate("c_date");
	}
}
