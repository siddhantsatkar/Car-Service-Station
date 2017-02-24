/**
 * 
 */
package com.charlotte.carservice.model;

import com.charlotte.carservice.Beans.UserBean;
import com.charlotte.carservice.dao.AdminDao;
import com.charlotte.carservice.dao.UserDao;

/**
 * @author Pritam
 *
 */
public class LoginUser {
	public boolean isValidUser(UserBean userBean)
	{
		UserDao userDao = new UserDao();	
		return userDao.isValidUser(userBean);
	}

	public boolean isValidAdmin(UserBean userBean) {
		// TODO Auto-generated method stub
		AdminDao adminDao = new AdminDao();	
		return adminDao.isValidAdmin(userBean);
	}
}
