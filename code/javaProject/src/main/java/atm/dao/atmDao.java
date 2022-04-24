package atm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import atm.domain.atm;

/**
 * DDL functions performed in database
 */
public class atmDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "test"; //TODO change user
	
	/**
	 * atm_location of your atm_id to connect to the database
	 */
	private String MySQL_atm_location = "12345678"; //TODO change atm_location

	public atm findByatm_id(String atm_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		atm atm = new atm();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_atm_location);
		    String sql = "select * from atm where atm_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,atm_id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    
		    while(resultSet.next()){
		    	String id = resultSet.getString("atm_id");
		    	if(id.equals(atm_id)){
		    		atm.setatm_id(resultSet.getString("atm_id"));
		    		atm.setatm_location(resultSet.getString("atm_location"));
		    		atm.setatm_last_restocked(resultSet.getString("atm_last_restocked"));
		    		atm.setassociated_warehouse(resultSet.getString("associated_warehouse"));	
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return atm;
	}
	
	/**
	 * insert atm
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(atm form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_atm_location);
			
			String sql = "insert into atm values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getatm_id());
		    preparestatement.setString(2,form.getatm_location());
		    preparestatement.setString(3,form.getatm_last_restocked());
		    preparestatement.setString(4,form.getassociated_warehouse());
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
	public void update(atm form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_atm_location);
			
			String sql = "UPDATE atm SET atm_location = ?, atm_last_restocked = ?, associated_warehouse = ? where atm_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getatm_location());
			preparestatement.setString(2,form.getatm_last_restocked());
			preparestatement.setString(3,form.getassociated_warehouse());
		    preparestatement.setString(4,form.getatm_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param atm_id
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String atm_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_atm_location);
			
			String sql = "delete from atm where atm_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,atm_id);
		    System.out.println(atm_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
