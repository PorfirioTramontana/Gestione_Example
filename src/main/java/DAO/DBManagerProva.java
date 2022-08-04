package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManagerProva {

	 private static Connection conn = null;
		
		private DBManagerProva() {}
		
		public static Connection getConnection() throws SQLException {
			
			if(conn == null|| conn.isClosed()) {
				conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/pkg", "sa", "");
			}
			
			return conn;
		}
		
		
		public static void closeConnection() throws SQLException {

			if(conn != null && !conn.isClosed()) {
				conn.close();
				conn=null;
			}
		}
}