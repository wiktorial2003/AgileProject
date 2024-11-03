package Database;

import java.sql.*;

import Customer.Customer;
import Order.Order;

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
	private ResultSetMetaData rsmd = null;
	
	
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

	// UPDATE MISSING!!
	
	
	// Insert Order
	public boolean insertOrderDetails(Order o) 
	{
		boolean insertSuccessful = true;
		
		try 
		{
			//Create prepared statement to issue SQL query to the database
			preparedStatement = con.prepareStatement("insert into newspaper_db_1.orders values (default, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, o.getCus_id());
			preparedStatement.setInt(2, o.getPub_id());
			preparedStatement.setInt(3, o.getQuantity_pub());
			preparedStatement.setString(4, o.getDel_date());
			preparedStatement.setDouble(5, o.getPrice());
			preparedStatement.executeUpdate();
		
		}
		catch (Exception e) 
		{
			insertSuccessful = false;
			e.printStackTrace();
		}
		
		return insertSuccessful;
	}
	// Read
	public ResultSet getAllOrders() 
	{
		try 
		{
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from orders");
		}
		catch (Exception e) 
		{
			resultSet = null;
		}
		return resultSet;
	}
	
	//Update
	/*
	 * public boolean editOrder(Order o) { boolean editSuccessful = true;
	 * 
	 * try { statement = con.createStatement(); resultSet =
	 * statement.executeQuery("select order_id from orders where order_id = " +
	 * o.getOrder_id()); rsmd = resultSet.getMetaData(); int columnNumber =
	 * rsmd.getColumnCount(); resultSet.next(); System.out.println(columnNumber); if
	 * (columnNumber >= 1) { String temp_id = resultSet.getString(columnNumber);
	 * System.out.println(temp_id); } else { int temp_id =
	 * resultSet.getInt(columnNumber); System.out.println(temp_id); }
	 * 
	 * }
	 * 
	 * catch (Exception e) {
	 * 
	 * System.out.println(""); editSuccessful = false; e.printStackTrace(); }
	 * 
	 * return editSuccessful;
	 * 
	 * }
	 */
	
	//Delete
	public boolean deleteOrderById(int order_id) 

	{
		boolean deleteSuccessful = true;
		
		try 
		{
			if (order_id == -99) 
			{
				preparedStatement = con.prepareStatement("delete from newspaper_db_1.orders");
			}
			else 
			{
				preparedStatement = con.prepareStatement("delete from newspaper_db_1.orders where id = " + order_id);
				preparedStatement.executeUpdate();
			}
		}
		catch (Exception e) 
		{
			deleteSuccessful = false;
		}
		
		return deleteSuccessful;
	}
	/*
	 * public static void main(String[] args) throws Exception { Database db = new
	 * Database(); Order o = new Order(1, 1.99, 1, "ya", 1);
	 * System.out.println(db.editOrder(o));
	 * 
	 * }
	 */
}

