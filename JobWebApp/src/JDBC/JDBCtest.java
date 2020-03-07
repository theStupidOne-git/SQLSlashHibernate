package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCtest {
		public static void main(String[] args) {

			String jdbcUrl = "jdbc:mysql://localhost:3306/idunno?useSSL=false&serverTimezone=UTC";
			String user = "Dunno";
			String pass = "Dunno";
			
			try {
				System.out.println("Connecting to database: " + jdbcUrl);
				
				Connection myConn =
						DriverManager.getConnection(jdbcUrl, user, pass);
							
				System.out.println("Connection successful!!!");
				
			}
			catch (Exception exc) {
				System.out.println("Something is wrong");
				exc.printStackTrace();
			}
			
		}

	}

