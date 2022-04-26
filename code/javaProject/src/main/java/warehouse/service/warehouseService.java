package warehouse.service;


import warehouse.dao.warehouseDao;
import warehouse.domain.warehouse;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class warehouseService {
	private warehouseDao warehouseDao = new warehouseDao();
	
	/**
	 * register a warehouse
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(warehouse form) throws warehouseException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of warehouse
		warehouse warehouse = warehouseDao.findBywarehouse_id(form.getwarehouse_id());
		if(warehouse.getwarehouse_id()!=null && warehouse.getwarehouse_id().equals(form.getwarehouse_id())) throw new warehouseException("This user name has been registered!");
		warehouseDao.add(form);
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
	public void login(warehouse form) throws warehouseException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		warehouse user = warehouseDao.findBywarehouse_id(form.getwarehouse_id());
		if(user.getwarehouse_id()==null) throw new warehouseException("The user is not in the database");
		
		String warehouse_location = user.getwarehouse_location();
		
		if(warehouse_location!=null && !warehouse_location.equals(form.getwarehouse_location()))
			throw new warehouseException(" The warehouse_location is not right");
		
	}
}
