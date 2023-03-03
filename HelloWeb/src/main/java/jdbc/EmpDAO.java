package jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EmpDAO {
	Connection conn;
	public void connect() {

		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Map<String, Object> getEmpInfo(int empId){
		connect(); //conn객체.
		String sql = "select * from employees where employee_id = ?";
		Map<String, Object> result = new HashMap<>();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1,empId);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				result.put("id", rs.getInt("employee_id"));
				result.put("firstName", rs.getString("first_name"));
				result.put("lastname", rs.getString("last_name"));
				result.put("salary", rs.getInt("salary"));
				result.put("jobid", rs.getString("job_id"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	//단건등록
	public int insertEmp(Map<String, Object>map) {
		int r = 0;

		try {
			connect();
			String sql = "insert into employees (employee_id, email, hire_date, job_id, last_name)"
					+ " values(?, ?, ?, ?, ?)";
			PreparedStatement psmt;
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, (String) map.get("eid"));
			psmt.setString(2, (String) map.get("email"));
			psmt.setString(3, (String) map.get("hire"));
			psmt.setString(4, (String) map.get("job"));
			psmt.setString(5, (String) map.get("last"));
			r = psmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return r;

	}
}
