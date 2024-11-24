package Database;

import java.sql.*;

import Customer.Customer;
import Order.Order;
import Publication.Publication;

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
	
	//CUSTOMER ------------------------------------------------------
	
	//Insert a customer in the db getting the customer object
	
	public boolean insertCustomerDetailsAccount(Customer c) 
	{
		boolean insertSuccessful = true;
		
		try 
		{
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
	
	//Update customer details by ID
	
	public boolean updateCustomerById(int customer_id, Customer updatedCustomer) //object to pass during update 
	{
		boolean updateSuccessful = true;
		try 
		{
			preparedStatement = con.prepareStatement("UPDATE newspaper_db_1.customers SET name = ?, address = ?, phoneNo = ?, isAway = ? WHERE customer_id = ?");
			
			//Set the parameters for the prepared statement from the update customer data
			
			preparedStatement.setString(1, updatedCustomer.getName());
			preparedStatement.setString(2, updatedCustomer.getAddress());
			preparedStatement.setInt(3, updatedCustomer.getPhoneNo());
			preparedStatement.setBoolean(4, updatedCustomer.getIsAway());
			preparedStatement.setInt(5, customer_id);
			
			
			//Execute update
			
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected == 0) 
			{
				updateSuccessful = false; // No rows updated, invalid ID
				System.out.println("Customer not updated, possibly invalid id");
			}
		}
		catch (Exception e) 
		{
			updateSuccessful = false;
			e.printStackTrace();
		}
		
		return updateSuccessful;
	}
	
	
	//Delete customers by the id
	public boolean deleteCustomerById(int customer_id) 

	{
		boolean deleteSuccessful = true;
		
		try 
		{
			int rowsAffected = 0;
			if (customer_id == -99) 
			{
				preparedStatement = con.prepareStatement("DELETE FROM newspaper_db_1.customers");
				preparedStatement.executeUpdate();
			}
			else 
			{
				preparedStatement = con.prepareStatement("DELETE FROM newspaper_db_1.customers WHERE customer_id = ?");
				preparedStatement.setInt(1, customer_id);
			 rowsAffected = preparedStatement.executeUpdate(); // Execute the update here
			}
		    
	        if (rowsAffected == 0) {
	            deleteSuccessful = false; // No rows deleted, possibly invalid customer_id
	        }
		}
		catch (Exception e) 
		{
			deleteSuccessful = false;
			e.printStackTrace();
		}
		
		return deleteSuccessful;
	}

	
	// ORDER --------------------------------------------------------
	
	// Insert Order
	public boolean insertPublicationDetails(Publication o) 
	{
		boolean insertSuccessful = true;
		
		try 
		{
			//Create prepared statement to issue SQL query to the database
			preparedStatement = con.prepareStatement("insert into newspaper_db_1.publications values (default, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, o.getPubName());
			preparedStatement.setInt(2, o.getStock());
			preparedStatement.setString(3, o.getPubType());
			preparedStatement.setDouble(4, o.getPubPrice());
			preparedStatement.setString(5, o.getFrequency());
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
	public ResultSet getAllPublications() 
	{
		try 
		{
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from publications");
		}
		catch (Exception e) 
		{
			resultSet = null;
		}
		return resultSet;
	}
	
	//Update
	public boolean updatePublicationById(int pub_id, Publication updatedPub)
	{
		boolean updateSuccessful = true;
		try 
		{
			preparedStatement = con.prepareStatement("UPDATE newspaper_db_1.publications SET name = ?, in_stock = ?, type = ?, del_date = ?, price = ?, frequency = ? WHERE pub_id = ?");
			
			//Set the parameters for the prepared statement from the update order data
			
			preparedStatement.setString(1, updatedPub.getPubName());
			preparedStatement.setInt(2, updatedPub.getStock());
			preparedStatement.setString(3, updatedPub.getPubType());
			preparedStatement.setDouble(4, updatedPub.getPubPrice());
			preparedStatement.setString(5, updatedPub.getFrequency());
			preparedStatement.executeUpdate();
			
			
			//Execute update
			
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected == 0) 
			{
				updateSuccessful = false; // No rows updated, invalid ID
				System.out.println("Order not updated, possibly invalid pub id");
			}
		}
		catch (Exception e) 
		{
			updateSuccessful = false;
			e.printStackTrace();
		}
		
		return updateSuccessful;
	}
	
	//Delete
	public boolean deletePublicationById(int pub_id) 

	{
		boolean deleteSuccessful = true;
		
		try 
		{
			if (pub_id == -99) 
			{
				preparedStatement = con.prepareStatement("delete from newspaper_db_1.orders");
			}
			else 
			{
				preparedStatement = con.prepareStatement("delete from newspaper_db_1.orders where id = " + pub_id);
				preparedStatement.executeUpdate();
			}
		}
		catch (Exception e) 
		{
			deleteSuccessful = false;
		}
		
		return deleteSuccessful;
	}
	
	
	//PUBLICATION --------------------------------------------------
	
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
	public boolean updateOrderById(int order_id, Order updatedOrder)
	{
		boolean updateSuccessful = true;
		try 
		{
			preparedStatement = con.prepareStatement("UPDATE newspaper_db_1.customers SET customer_id = ?, pub_id = ?, quantity_pub = ?, del_date = ?, price = ? WHERE order_id = ?");
			
			//Set the parameters for the prepared statement from the update order data
			
			preparedStatement.setInt(1, updatedOrder.getCus_id());
			preparedStatement.setInt(2, updatedOrder.getPub_id());
			preparedStatement.setInt(3, updatedOrder.getQuantity_pub());
			preparedStatement.setString(4, updatedOrder.getDel_date());
			preparedStatement.setDouble(5, updatedOrder.getPrice());
			preparedStatement.setInt(6, order_id);
			
			
			//Execute update
			
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected == 0) 
			{
				updateSuccessful = false; // No rows updated, invalid ID
				System.out.println("Order not updated, possibly invalid order id");
			}
		}
		catch (Exception e) 
		{
			updateSuccessful = false;
			e.printStackTrace();
		}
		
		return updateSuccessful;
	}
	
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
	
}

