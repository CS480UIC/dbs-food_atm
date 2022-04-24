package atm.service;


import atm.dao.atmDao;
import atm.domain.atm;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class atmService {
	private atmDao atmDao = new atmDao();
	
	/**
	 * register a atm
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(atm form) throws atmException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of atm
		atm atm = atmDao.findByatm_id(form.getatm_id());
		if(atm.getatm_id()!=null && atm.getatm_id().equals(form.getatm_id())) throw new atmException("This user name has been registered!");
		atmDao.add(form);
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
	public void login(atm form) throws atmException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		atm user = atmDao.findByatm_id(form.getatm_id());
		if(user.getatm_id()==null) throw new atmException("The user is not in the database");
		
		String atm_location = user.getatm_location();
		
		if(atm_location!=null && !atm_location.equals(form.getatm_location()))
			throw new atmException(" The atm_location is not right");
		
	}
}
