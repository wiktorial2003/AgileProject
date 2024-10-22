package Database;

import java.sql.*;

import Customer.Customer;

public class Database 
{
	private String url = "jdbc:mysql://localhost:3306/newspaper_db_1?useTimezone=true&serverTimezone=UTC";
	private String username = "root";
	private String password = "root";
	private String driverName = "com.mysql.cj.jdbc.Driver";
	private Connection con;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	public Database() throws Exception 
	{
		try 
		{
			Class.forName(driverName);
			try 
			{
				con = DriverManager.getConnection(url,  username, password);
			}
			catch (SQLException ex) 
			{
				System.out.println("Failed connect;");
			}
		}
		catch (Exception e) 
		{
			System.out.println("Error: Failed to connect to database\n" + e.getMessage());
		}
		
	}
	
	//Insert a customer in the db getting the customer object
	
	public boolean insertCustomerDetailsAccount(Customer c) 
	{
		boolean insertSuccessful = true;
		
		try 
		{
			System.out.println(c.getName() + " " + c.getAddress());
			//Create prepared statement to issue SQL query to the database
			preparedStatement = con.prepareStatement("insert into newspaper_db_1.customers values (default, ?, ?, ?, ?)");
			preparedStatement.setString(1, c.getName());
			preparedStatement.setString(2, c.getAddress());
			preparedStatement.setInt(3, c.getPhoneNo());
			preparedStatement.setBoolean(4, c.getIsAway());
			preparedStatement.executeUpdate();
		
		}
		catch (Exception e) 
		{
			insertSuccessful = false;
			e.printStackTrace();
		}
		
		return insertSuccessful;
	}
	// Get list of all customers
	public ResultSet getAllCustomers() 
	{
		try 
		{
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from customers");
		}
		catch (Exception e) 
		{
			resultSet = null;
		}
		return resultSet;
	}
	//Delete customers by the id
	public boolean deleteCustomerById(int customer_id) 
	{
		boolean deleteSuccessful = true;
		
		try 
		{
			if (customer_id == -99) 
			{
				preparedStatement = con.prepareStatement("delete from newspaper_db_1.customers");
			}
			else 
			{
				preparedStatement = con.prepareStatement("delete from newspaper_db_1.customer where id = " + customer_id);
				preparedStatement.executeUpdate();
			}
		}
		catch (Exception e) 
		{
			deleteSuccessful = false;
		}
		
		return deleteSuccessful;
	}
	
	
	
}