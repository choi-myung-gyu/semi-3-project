package temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TempDAO {
	
	private Connection connection = null;
	
	public TempDAO() {
		String driver_name = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "web_admin";
		String password = "web_admin";
		
		try {
			Class.forName(driver_name);
			this.connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<TempVO> getAll(){
		ArrayList<TempVO> results = new ArrayList<TempVO>();
		String sql = "SELECT id, name, c_date FROM temp_t ORDER BY c_date DESC";
		
		try {
			PreparedStatement pstat = this.connection.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				TempVO data = new TempVO();
				data.setRecord(rs);
				results.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	public TempVO selectId(int id){
		TempVO result = null;
		
		String sql = "SELECT id, name, c_date FROM temp_t WHERE id = ?";
		
		try {
			PreparedStatement pstat = this.connection.prepareStatement(sql);
			pstat.setInt(1, id);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				TempVO data = new TempVO();
				data.setRecord(rs);
				result = data;
				break;	// 하나의 데이터만을 조회하여 사용하기 때문에 반복 필요 없음.
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
//	public ArrayList<TempVO> selectName(String name){
//		
//	}
	
//	public ArrayList<TempVO> selectDate(Date date){
//		
//	}
	
	public TempVO insert(TempVO data) {
		int result = 0;
		String sql = "SELECT id FROM (SELECT id FROM temp_t ORDER BY id DESC) WHERE ROWNUM = 1";
		
		try {
			PreparedStatement pstat = this.connection.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			rs.next();
			int id = rs.getInt("id") + 1;
			
			sql = "INSERT INTO temp_t(id, name, c_date) VALUES(?, ?, SYSDATE)";
			pstat = this.connection.prepareStatement(sql);
			pstat.setInt(1, id);
			pstat.setString(2, data.getName());
			result = pstat.executeUpdate();
			
			if(result == 1) {
				sql = "SELECT id, name, c_date FROM temp_t WHERE id = ?";
				pstat = this.connection.prepareStatement(sql);
				pstat.setInt(1, id);
				rs = pstat.executeQuery();
				rs.next();
				data.setRecord(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public int update(TempVO data) {
		int result = 0;
		
		String sql = "UPDATE temp_t SET name = ? WHERE id = ?";
		
		try {
			PreparedStatement pstat = this.connection.prepareStatement(sql);
			pstat.setString(1, data.getName());
			pstat.setInt(2, data.getId());
			result = pstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int delete(int id) {
		int result = 0;
		
		String sql = "DELETE FROM temp_t WHERE id = ?";
		
		try {
			PreparedStatement pstat = this.connection.prepareStatement(sql);
			pstat.setInt(1, id);
			result = pstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
