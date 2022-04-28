package location.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class location {
	/*
	 * Correspond to the user table
	 */
	
	private String location_id;
	private String location_type; 
	private String address;
	
	
	public String getlocation_id() {
		return location_id;
	}

	public void setlocation_id(String location_id) {
		this.location_id = location_id;
	}

	public String getlocation_type() {
		return location_type;
	}

	public void setlocation_type(String location_type) {
		this.location_type = location_type;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [ location_id=" + location_id + ", location_type="
				+ location_type + ", address=" + address +"]";
	}
}
