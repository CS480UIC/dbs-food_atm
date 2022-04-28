package location.service;


import location.dao.locationDao;
import location.domain.location;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class locationService {
	private locationDao locationDao = new locationDao();
	
	/**
	 * register a location
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(location form) throws locationException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of location
		location location = locationDao.findBylocation_id(form.getlocation_id());
		if(location.getlocation_id()!=null && location.getlocation_id().equals(form.getlocation_id())) throw new locationException("This user name has been registered!");
		locationDao.add(form);
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
	public void login(location form) throws locationException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		location user = locationDao.findBylocation_id(form.getlocation_id());
		if(user.getlocation_id()==null) throw new locationException("The user is not in the database");
		
		String location_type = user.getlocation_type();
		
		if(location_type!=null && !location_type.equals(form.getlocation_type()))
			throw new locationException(" The location_type is not right");
		
	}
}
