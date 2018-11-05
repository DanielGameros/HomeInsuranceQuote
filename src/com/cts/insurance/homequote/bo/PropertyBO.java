/**
 * This Business Object class is used to for Property Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import com.cts.insurance.homequote.dao.PropertyDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Property;

public class PropertyBO {

	/**
	 * @param quoteId
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Property getProperty(final int quoteId) throws HomequoteBusinessException {

		final PropertyDAO pDAO = new PropertyDAO();
		
		// FILLED CODE
		//Can probably be done a better way
		Property p = new Property();

		try {
			
			p.setQuoteId(pDAO.getProperty(quoteId).getQuoteId());
			p.setMarketValue(pDAO.getProperty(quoteId).getMarketValue());
			p.setYearBuilt(pDAO.getProperty(quoteId).getYearBuilt());
			p.setSquareFootage(pDAO.getProperty(quoteId).getSquareFootage());
			p.setDwellingStyle(pDAO.getProperty(quoteId).getDwellingStyle());
			p.setRoofMaterial(pDAO.getProperty(quoteId).getRoofMaterial());
			p.setGarageType(pDAO.getProperty(quoteId).getGarageType());
			p.setNumFullBaths(pDAO.getProperty(quoteId).getNumFullBaths());
			p.setNumHalfBaths(pDAO.getProperty(quoteId).getNumHalfBaths());
			p.setHasSwimmingPool(pDAO.getProperty(quoteId).isHasSwimmingPool());
			
		} catch (HomequoteSystemException e) {
			throw new HomequoteBusinessException(e.getMessage());
		}

		return p; // return Object;
	}

	/**
	 * @param property
	 * @throws HomequoteBusinessException
	 */
	public void saveProperty(final Property property) throws HomequoteBusinessException {

		final PropertyDAO PropertyDAO = new PropertyDAO();
		try {
			PropertyDAO.saveProperty(property);
		} catch (HomequoteSystemException e) {
			throw new HomequoteBusinessException(e.getMessage());
		}
	}

}
