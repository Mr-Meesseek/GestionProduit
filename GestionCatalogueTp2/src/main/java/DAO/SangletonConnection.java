package DAO;

import java.sql.*;

public class SangletonConnection {
	private static Connection connection;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Produit","root","");
			System.out.println("connection etablie");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		return connection;
		
	}
}