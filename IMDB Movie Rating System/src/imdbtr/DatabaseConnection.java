package imdbtr;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

// This class can be used to initialize the database connection 
public class DatabaseConnection { 

	protected static Connection initializeDatabase() 
		throws SQLException, ClassNotFoundException 
	{ 
		


		// Initialize all the information regarding 
		// Database Connection 
		
		String dbDriver = "com.mysql.jdbc.Driver"; 
		String dbURL = "jdbc:mysql:// localhost:3306/"; 
		// Database name to access 
		
		String dbName = "imdbtr"; 
		String dbUsername = "root"; 
		String dbPassword = "tiger"; 
		
		Class.forName(dbDriver); 
		System.out.println("heello2");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imdbtr",dbUsername,dbPassword); 
		System.out.println("working");
		return con; 
	} 
} 
