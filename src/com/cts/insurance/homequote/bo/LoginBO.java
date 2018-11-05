/**
 * This Action class is used to to capture the Location Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import com.cts.insurance.homequote.dao.LoginDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.User;

public class LoginBO {
	

	/**
	 * @param userName
	 * @param password
	 * @return
	 * @throws HomequoteSystemException 
	 */
	public User getUser(final String userName) throws HomequoteBusinessException, HomequoteSystemException{

		final LoginDAO loginDAO = new LoginDAO();
		
		User user = null;
		user = loginDAO.getUser(userName);

		return user ;
		//return loginDAO.getUser(userName);
	}
	
	/**
	 * registerUser
	 * @param user
	 * @throws HomequoteBusinessException
	 */
	public void registerUser(final User user) throws HomequoteBusinessException{

		final LoginDAO loginDAO = new LoginDAO();
		try {
			loginDAO.saveUser(user);
		} catch (HomequoteSystemException e) {
			e.printStackTrace();
		}
	}
}
