package warehouse.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class warehouse {
	/*
	 * Correspond to the user table
	 */
	
	private String warehouse_id;
	private String warehouse_location; 
	private String warehouse_last_restocked;
	
	
	public String getwarehouse_id() {
		return warehouse_id;
	}

	public void setwarehouse_id(String warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	public String getwarehouse_location() {
		return warehouse_location;
	}

	public void setwarehouse_location(String warehouse_location) {
		this.warehouse_location = warehouse_location;
	}

	public String getwarehouse_last_restocked() {
		return warehouse_last_restocked;
	}

	public void setwarehouse_last_restocked(String warehouse_last_restocked) {
		this.warehouse_last_restocked = warehouse_last_restocked;
	}

	@Override
	public String toString() {
		return "User [ warehouse_id=" + warehouse_id + ", warehouse_location="
				+ warehouse_location + ", warehouse_last_restocked=" + warehouse_last_restocked +"]";
	}
}
