package connessione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connessione {
	public Connection connetti() {
		Connection connessione = null;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/scuolaesami";
		String user="root";
		String pw="";
		
		try {
			Class.forName(driver);
			connessione=DriverManager.getConnection(url,user,pw);
			
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
		}
		return connessione;
		
	}
}
