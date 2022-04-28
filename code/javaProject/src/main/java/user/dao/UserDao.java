package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import user.domain.User;
import food.domain.food;
import atm.domain.atm;
import warehouse.domain.warehouse;



/**
 * DDL functions performed in database
 */
public class UserDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "test";  //TODO change user
	
	/**
	 * password of your user_id to connect to the database
	 */
	private String MySQL_password = "12345678";  //TODO change password
	
	/**
	 * get the Search result with user_id 
	 */
	public User findByuser_id(String user_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = new User();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_password);
		    String sql = "select * from user where user_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user_id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("user_id");
		    	if(user_name.equals(user_id)){
		    		user.setuser_id(resultSet.getString("user_id"));
		    		user.setPassword(resultSet.getString("password"));
		    		user.setuser_type(resultSet.getString("user_type"));
		    		
		    	}
		    }
		
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}
	

	
	
	/**
	 * insert User
	 */
	public void add(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_password);
			
			String sql = "insert into user values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getuser_id());
		    preparestatement.setString(2,user.getPassword());
		    preparestatement.setString(3,user.getuser_type());
		    preparestatement.setString(4,"0");
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_password);
			String sql = "select * from user";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				User user = new User();
				user.setuser_id(resultSet.getString("user_id"));
	    		user.setPassword(resultSet.getString("password"));
	    		user.setuser_type(resultSet.getString("user_type"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> simple0() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_password);
			String sql = "SELECT * FROM food WHERE quantity > 3 ORDER BY name";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				food food = new food();
				food.setfood_id(resultSet.getString("food_id"));
	    		food.setname(resultSet.getString("name"));
	    		food.setfood_location(resultSet.getString("food_location"));
	    		food.setquantity(resultSet.getString("quantity"));
	    		list.add(food);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> simple1() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_password);
			String sql = "select * from atm where atm_id like '%45%' order by associated_warehouse";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				atm atm = new atm();
				atm.setatm_id(resultSet.getString("atm_id"));
	    		atm.setatm_location(resultSet.getString("atm_location"));
	    		atm.setatm_last_restocked(resultSet.getString("atm_last_restocked"));
	    		atm.setassociated_warehouse(resultSet.getString("associated_warehouse"));
	    		list.add(atm);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> aggregate0() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_password);
			String sql = "SELECT SUM(balance) FROM user";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				User user = new User();
				user.setuser_id(resultSet.getString("SUM(balance)"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> aggregate1() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_password);
			String sql = "SELECT user_type, sum(balance) FROM user GROUP BY user_type";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				User user = new User();
				user.setuser_type(resultSet.getString("user_type"));
	    		user.setuser_id(resultSet.getString("sum(balance)"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> aggregate2() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_password);
			String sql = "select warehouse_last_restocked, COUNT(warehouse_id) from warehouse group by warehouse_last_restocked";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				warehouse warehouse = new warehouse();
				warehouse.setwarehouse_last_restocked(resultSet.getString("warehouse_last_restocked"));
				warehouse.setwarehouse_id(resultSet.getString("COUNT(warehouse_id)"));
	    		list.add(warehouse);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> aggregate3() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_password);
			String sql = "select COUNT(user()) as count, user_type as type from user group by user_type";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				User user = new User();
				user.setuser_id(resultSet.getString("count"));
				user.setuser_type(resultSet.getString("type"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> complex0() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_password);
			String sql = "select location.address, warehouse.warehouse_id from location inner join warehouse on location.location_id = warehouse.warehouse_location";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				warehouse warehouse = new warehouse();
				warehouse.setwarehouse_id(resultSet.getString("warehouse_id"));
				warehouse.setwarehouse_location(resultSet.getString("address"));
	    		list.add(warehouse);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> complex1() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_password);
			String sql = "SELECT food_location, quantity FROM food WHERE 1 <= (SELECT COUNT(*) FROM location WHERE location_type = 2)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				food food = new food();
				food.setfood_location(resultSet.getString("food_location"));
				food.setname(resultSet.getString("quantity"));
	    		list.add(food);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> complex2() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_password);
			String sql = "select COUNT(user()) as count, user_type as type from user group by user_type";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				User user = new User();
				user.setuser_id(resultSet.getString("count"));
				user.setuser_type(resultSet.getString("type"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
		
}
