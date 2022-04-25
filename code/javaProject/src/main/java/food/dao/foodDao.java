package food.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import food.domain.food;

/**
 * DDL functions performed in database
 */
public class foodDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "test"; //TODO change user
	
	/**
	 * name of your food_id to connect to the database
	 */
	private String MySQL_name = "12345678"; //TODO change name

	public food findByfood_id(String food_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		food food = new food();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_name);
		    String sql = "select * from food where food_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,food_id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    
		    while(resultSet.next()){
		    	String id = resultSet.getString("food_id");
		    	if(id.equals(food_id)){
		    		food.setfood_id(resultSet.getString("food_id"));
		    		food.setname(resultSet.getString("name"));
		    		food.setfood_location(resultSet.getString("food_location"));
		    		food.setquantity(resultSet.getString("quantity"));	
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return food;
	}
	
	/**
	 * insert food
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(food form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_name);
			
			String sql = "insert into food values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getfood_id());
		    preparestatement.setString(2,form.getname());
		    preparestatement.setString(3,form.getfood_location());
		    preparestatement.setString(4,form.getquantity());
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
	public void update(food form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_name);
			
			String sql = "UPDATE food SET name = ?, food_location = ?, quantity = ? where food_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getname());
			preparestatement.setString(2,form.getfood_location());
			preparestatement.setString(3,form.getquantity());
		    preparestatement.setString(4,form.getfood_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param food_id
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String food_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_name);
			
			String sql = "delete from food where food_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,food_id);
		    System.out.println(food_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
