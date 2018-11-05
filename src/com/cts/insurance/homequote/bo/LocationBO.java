/**
 * This Business Object class is used to for Location Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import java.util.ArrayList;
import java.util.List;

import com.cts.insurance.homequote.dao.LocationDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Location;

public class LocationBO {

	/**
	 * @param location
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public int saveHomeLocation(final Location location) throws HomequoteBusinessException {

		final LocationDAO locationDAO = new LocationDAO();
		
		// FILLED CODE
		int quoteID = 1;

		try {
			
			quoteID = locationDAO.saveLocation(location);
		} catch (HomequoteSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return quoteID; // return integer
	}

	/**
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Location getHomeLocation(int quoteId) throws HomequoteBusinessException {

		final LocationDAO locationDAO = new LocationDAO();

		// FILLED CODE
		Location loc = new Location();
		try {
			loc.setQuoteId(locationDAO.getLocation(quoteId).getQuoteId());// QUOTE_ID
			loc.setResidenceType(locationDAO.getLocation(quoteId).getResidenceType());// RESIDENCE_TYPE
			loc.setAddressLine1(locationDAO.getLocation(quoteId).getAddressLine1());// ADDRESS_LINE_1
			loc.setAddressLine2(locationDAO.getLocation(quoteId).getAddressLine2());// ADDRESS_LINE_2
			loc.setCity(locationDAO.getLocation(quoteId).getCity());// CITY
			loc.setState(locationDAO.getLocation(quoteId).getState());// STATE
			loc.setZip(locationDAO.getLocation(quoteId).getZip());// ZIP
			loc.setResidenceUse(locationDAO.getLocation(quoteId).getResidenceUse());// RESIDENCE_USE
			loc.setUserName(locationDAO.getLocation(quoteId).getUserName());// USER_NAME

		} catch (HomequoteSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return loc; // return Object
	}

	/**
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public List<Location> getQuoteIds(String userName) throws HomequoteBusinessException {

		final LocationDAO locationDAO = new LocationDAO();

		// FILLED CODE
		ArrayList<Location> locList = null;

		try {
			locList = new ArrayList<Location>();
			locList.addAll(locationDAO.getQuoteIds(userName));

		} catch (HomequoteSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return locList; // return list of Object
	}

}
