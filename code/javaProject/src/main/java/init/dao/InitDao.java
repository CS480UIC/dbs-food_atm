package init.dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;





/**
 * DDL functions performed in database
 */
public class InitDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "test";  //TODO change user
	
	/**
	 * password of your user_id to connect to the database
	 */
	private String MySQL_password = "12345678";  //TODO change password
	

	/**
	 * insert User
	 * @param input 
	 * @throws ClassNotFoundException 
	 */
	public void initialize(InputStream input) throws ClassNotFoundException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_atm", MySQL_user, MySQL_password);
			
			 //Initialize the script runner
	   		 	ScriptRunner sr = new ScriptRunner(connect);
	   		 //Creating a reader object
	   		 Reader reader = new InputStreamReader(input);
	   		 //Running the script
	   		 sr.runScript(reader);

		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
		
}
