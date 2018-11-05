/**
 * This Business Object class is used to for Homeowner Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import com.cts.insurance.homequote.dao.HomeownerDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Homeowner;

public class HomeownerBO {

	/**
	 * @param quoteId
	 * @param lastName
	 * @param dob
	 * @param emailAddress
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Homeowner getHomeownerInfo(final int quoteId) throws HomequoteBusinessException{

		final HomeownerDAO homeownerDAO = new HomeownerDAO();
		
		//FILLED CODE 
		Homeowner homeOwner = null;
		try {
			homeOwner = homeownerDAO.getHomeowner(quoteId);
		} catch (HomequoteSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return homeOwner; //return Object
	}
	/**
	 * @param homeowner
	 * @throws HomequoteBusinessException
	 */
	public void saveHomeownerInfo(final Homeowner homeowner) throws HomequoteBusinessException{

		final HomeownerDAO homeOwnerDAO = new HomeownerDAO();
        //FILLED CODE
		try {
			homeOwnerDAO.saveHomeowner(homeowner);
		} catch (HomequoteSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
