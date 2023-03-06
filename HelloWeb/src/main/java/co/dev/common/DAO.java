package co.dev.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * connection, preparedstatement, resultset 
 */
public class DAO {
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public void getConn() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disConn() {
		//resource 환원
		try {
			if(conn != null) {
				conn.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
}

