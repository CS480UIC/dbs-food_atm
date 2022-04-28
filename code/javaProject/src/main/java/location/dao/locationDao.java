package location.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import location.domain.location;

/**
 * DDL functions performed in database
 */
public class locationDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "test"; //TODO change user
	
	/**
	 * location_type of your location_id to connect to the database
	 */
	private String MySQL_location_type = "12345678"; //TODO change location_type

	public location findBylocation_id(String location_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		location location = new location();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_location_type);
		    String sql = "select * from location where location_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,location_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String user_name = resultSet.getString("location_id");
		    	if(user_name.equals(location_id)){
		    		location.setlocation_id(resultSet.getString("location_id"));
		    		location.setlocation_type(resultSet.getString("location_type"));
		    		location.setaddress(resultSet.getString("address"));		
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return location;
	}	
	
	/**
	 * insert location
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(location form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_location_type);
			
			String sql = "insert into location values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getlocation_id());
		    preparestatement.setString(2,form.getlocation_type());
		    preparestatement.setString(3,form.getaddress());
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
	public void update(location form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_location_type);
			
			String sql = "UPDATE location SET location_type = ?, address = ? where location_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getlocation_type());
			preparestatement.setString(2,form.getaddress());
		    preparestatement.setString(3,form.getlocation_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param location_id
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String location_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_location_type);
			
			String sql = "delete from location where location_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,location_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
