package food.service;


import food.dao.foodDao;
import food.domain.food;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class foodService {
	private foodDao foodDao = new foodDao();
	
	/**
	 * register a food
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(food form) throws foodException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of food
		food food = foodDao.findByfood_id(form.getfood_id());
		if(food.getfood_id()!=null && food.getfood_id().equals(form.getfood_id())) throw new foodException("This user name has been registered!");
		foodDao.add(form);
	}
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws UserException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void login(food form) throws foodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		food user = foodDao.findByfood_id(form.getfood_id());
		if(user.getfood_id()==null) throw new foodException("The user is not in the database");
		
		String name = user.getname();
		
		if(name!=null && !name.equals(form.getname()))
			throw new foodException(" The name is not right");
		
	}
}
