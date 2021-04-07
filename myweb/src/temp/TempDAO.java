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
		String password = "admin";
		
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
		String sql = "SELECT id, name, c_date FROM temp_t";
		
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
//	
//	public ArrayList<TempVO> selectName(String name){
//		
//	}
//	
//	public ArrayList<TempVO> selectDate(Date date){
//		
//	}
//	
//	public void insertData(TempVO data) {
//		
//	}
//	
//	public void updateData(TempVO data) {
//		
//	}
//	
//	public void deleteData(TempVO data) {
//		
//	}
	
}
