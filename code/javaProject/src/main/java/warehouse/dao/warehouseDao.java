package warehouse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import warehouse.domain.warehouse;

/**
 * DDL functions performed in database
 */
public class warehouseDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "test"; //TODO change user
	
	/**
	 * warehouse_location of your warehouse_id to connect to the database
	 */
	private String MySQL_warehouse_location = "12345678"; //TODO change warehouse_location

	public warehouse findBywarehouse_id(String warehouse_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		warehouse warehouse = new warehouse();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_warehouse_location);
		    String sql = "select * from warehouse where warehouse_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,warehouse_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String user_name = resultSet.getString("warehouse_id");
		    	if(user_name.equals(warehouse_id)){
		    		warehouse.setwarehouse_id(resultSet.getString("warehouse_id"));
		    		warehouse.setwarehouse_location(resultSet.getString("warehouse_location"));
		    		warehouse.setwarehouse_last_restocked(resultSet.getString("warehouse_last_restocked"));		
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return warehouse;
	}	
	
	/**
	 * insert warehouse
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(warehouse form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_warehouse_location);
			
			String sql = "insert into warehouse values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getwarehouse_id());
		    preparestatement.setString(2,form.getwarehouse_location());
		    preparestatement.setString(3,form.getwarehouse_last_restocked());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(warehouse form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_warehouse_location);
			
			String sql = "UPDATE warehouse SET warehouse_location = ?, warehouse_last_restocked = ? where warehouse_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getwarehouse_location());
			preparestatement.setString(2,form.getwarehouse_last_restocked());
		    preparestatement.setString(3,form.getwarehouse_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param warehouse_id
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String warehouse_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_warehouse_location);
			
			String sql = "delete from warehouse where warehouse_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,warehouse_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
