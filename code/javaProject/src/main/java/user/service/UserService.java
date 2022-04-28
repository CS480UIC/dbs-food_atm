package user.service;

import java.util.List;

import user.dao.UserDao;
import user.domain.User;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 */
public class UserService {
	private UserDao userDao = new UserDao();
	
	/**
	 * Register a user
	 */
	public void regist(User form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		User user = userDao.findByuser_id(form.getuser_id());
		if(user.getuser_id()!=null && user.getuser_id().equals(form.getuser_id())) throw new UserException("This user name has been registered!");
		userDao.add(form);
	}
	
	
	/**
	 * Login function
	 */
	public void login(User form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = userDao.findByuser_id(form.getuser_id());
		if(user.getuser_id()==null) throw new UserException("The user is not in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new UserException(" The password is not right");
		
	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findall();
		
	}
	public List<Object> simple0() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.simple0();
		
	}
	public List<Object> simple1() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.simple1();
		
	}
	public List<Object> aggregate0() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.aggregate0();
		
	}
	public List<Object> aggregate1() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.aggregate1();
		
	}
	public List<Object> aggregate2() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.aggregate2();
		
	}
	public List<Object> aggregate3() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.aggregate3();
		
	}
}
