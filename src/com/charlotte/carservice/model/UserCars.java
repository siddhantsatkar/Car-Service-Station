/**
 * 
 */
package com.charlotte.carservice.model;

import java.util.List;

import com.charlotte.carservice.Beans.servicing_typeBean;
import com.charlotte.carservice.Beans.vehiclesBean;
import com.charlotte.carservice.Beans.ServiceSlotBean;
//import com.charlotte.carservice.controller.ServiceSlotBean;
import com.charlotte.carservice.dao.ServicingDao;
import com.charlotte.carservice.dao.UserDao;

/**
 * @author Pritam
 *
 */
public class UserCars {

	public List<vehiclesBean> getVehicles(String emailId) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();	
		return userDao.getVehicles(emailId);
	}
	
	public List<servicing_typeBean> getServicingTypes()
	{
		ServicingDao servicingDao=new ServicingDao();
		return servicingDao.getServicingTypes();
		
	}

	public List<ServiceSlotBean> getBookings(String emailId) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		return userDao.getBookings(emailId);
	}

	

}
