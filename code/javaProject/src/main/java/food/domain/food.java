package food.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class food {
	/*
	 * Correspond to the user table
	 */
	
	private String food_id;
	private String name; 
	private String food_location;
	private String quantity;
	
	public String getfood_id() {
		return food_id;
	}

	public void setfood_id(String food_id) {
		this.food_id = food_id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getfood_location() {
		return food_location;
	}

	public void setfood_location(String food_location) {
		this.food_location = food_location;
	}
	
	public String getquantity() {
		return quantity;
	}

	public void setquantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "User [ food_id=" + food_id + ", name="
				+ name + ", food_location=" + food_location +"]";
	}
}
