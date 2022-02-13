package utils;

import java.sql.*;

public class Basedonnee {


	private String URL;

	private String username;
	private String password;
	private String driverClasseName;
	
	
	/***************************************constructeur de bd*********************************************************/	
	
	public  Basedonnee (String uRL, String username, String password, String driverClasseName) {
			super();
			URL = uRL;
			this.username = username;
			this.password = password;
			this.setDriverClasseName(driverClasseName);
		}
		
		public Connection connectToDB() {
			try {
				Connection connection = 
						DriverManager.getConnection(URL, username, password);
				return connection;
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
			return null;
		}

		public String getDriverClasseName() {
			return driverClasseName;
		}

		public void setDriverClasseName(String driverClasseName) {
			this.driverClasseName = driverClasseName;
		}
		
	/***********************************************************************************************/
	
}
