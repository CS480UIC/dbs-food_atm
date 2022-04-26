package warehouse.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import warehouse.dao.warehouseDao;
import warehouse.domain.warehouse;


/**
 * Servlet implementation class UserServlet
 */

public class warehouseServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public warehouseServletRead() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		warehouse warehouse = null;
		warehouseDao warehouseDao = new warehouseDao();
		
		try {
			warehouse = warehouseDao.findBywarehouse_id(request.getParameter("warehouse_id"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(warehouse.getwarehouse_id()!=null){
					System.out.println(warehouse);
					request.setAttribute("warehouse", warehouse);
					request.getRequestDispatcher("/jsps/warehouse/warehouse_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/warehouse/warehouse_read_output.jsp").forward(request, response);
		}
	}
}



