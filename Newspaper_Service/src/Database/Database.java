package Database;

import java.sql.*;

public class Database 
{
	private String url = "jdbc:mysql://localhost:3306/newspaper_db_1?useTimezone=true&serverTimezone=UTC";
	private String username = "root";
	private String password = "root";
	private String driverName = "com.mysql.cj.jdbc.Driver";
	private Connection con;
	
	public Connection init_db() 
	{
	
		try 
		{
			Class.forName(driverName);
			try 
			{
				con = DriverManager.getConnection(url,  username, password);
				return con;
			}
			catch (SQLException ex) 
			{
				System.out.println("Failed connect;");
				return null;
			}

		}
		catch (Exception e) 
		{
			System.out.println("Error: Failed to connect to database\n" + e.getMessage());
			return null;
		}
		
	}
	
	public static void main(String[] args) 
	{
		Database db = new Database();
		Connection con1 = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con1 = db.init_db();
			rs = stmt.executeQuery("SELECT * from customers");
			System.out.println(rs.getRow());
			rs.next();
			


		}
		catch (Exception e)
		{
			System.out.println("Error: failed to get number of records");
		}
		try
		{
			con1.close();
		}
		catch (SQLException sqle)
		{
			System.out.println("Error: failed to close the database");
		}
	}

}