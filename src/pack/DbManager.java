package pack;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DbManager {

	protected static Connection getConnection() throws SQLException, ClassNotFoundException {

		// String dbDriver = "com.mysql.jdbc.Driver";
		final String url = "jdbc:mysql://localhost:3306/hibernate_db";
		final String user = "root";

		// create a connection to the database
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, null);

		return conn;
	}
}