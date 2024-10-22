package Database;

import java.sql.*;

public class Database 
{
	private static String url = "jbdc:mysql://localhost:3306/newspaper_db_1?useTimezone=true&serverTimezone=UTC";
	private static String username = "root";
	private static String password = "root";
	private static String driverName = "com.mysql.cj.jbdc.Driver";
	private static Connection con;
	private static String urlstring;
	public static Connection init_db() 
	{
	
		try 
		{
			Class.forName(driverName);
			try 
			{
				con = DriverManager.getConnection(url, username, password);
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
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = Database.init_db();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM customers");
		    	rs.next();//move to first row, the query above only produces 1 row
	    		String myTotal = rs.getString(0);
	    		System.out.println( myTotal);
		}
		catch (SQLException sqle)
		{
			System.out.println("Error: failed to get number of records");
		}
		try
		{
			con.close();
		}
		catch (SQLException sqle)
		{
			System.out.println("Error: failed to close the database");
		}
	}

}