package user.domain;

/**
 * User object
 * @author Aayush Makharia
 */
public class User {
	/*
	 * Correspond to the user table
	 */
	
	private String user_id;
	private String password; 
	private String user_type;
	private String balance;
	

	
	public String getuser_id() {
		return user_id;
	}

	public void setuser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getuser_type() {
		return user_type;
	}

	public void setuser_type(String user_type) {
		this.user_type = user_type;
	}

	
	@Override
	public String toString() {
		return "User [ user_id=" + user_id + ", password="
				+ password + ", user_type=" + user_type +"]";
	}
}
