package atm.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class atm {
	/*
	 * Correspond to the user table
	 */
	
	private String atm_id;
	private String atm_location; 
	private String atm_last_restocked;
	private String associated_warehouse;
	
	public String getatm_id() {
		return atm_id;
	}

	public void setatm_id(String atm_id) {
		this.atm_id = atm_id;
	}

	public String getatm_location() {
		return atm_location;
	}

	public void setatm_location(String atm_location) {
		this.atm_location = atm_location;
	}

	public String getatm_last_restocked() {
		return atm_last_restocked;
	}

	public void setatm_last_restocked(String atm_last_restocked) {
		this.atm_last_restocked = atm_last_restocked;
	}
	
	public String getassociated_warehouse() {
		return associated_warehouse;
	}

	public void setassociated_warehouse(String associated_warehouse) {
		this.associated_warehouse = associated_warehouse;
	}

	@Override
	public String toString() {
		return "User [ atm_id=" + atm_id + ", atm_location="
				+ atm_location + ", atm_last_restocked=" + atm_last_restocked +"]";
	}
}
