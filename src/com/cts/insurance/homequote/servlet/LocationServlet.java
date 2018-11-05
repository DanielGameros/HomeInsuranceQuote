/**
 * Servlet for capturing Location Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.insurance.homequote.bo.LocationBO;
import com.cts.insurance.homequote.dao.AbstractDAOFactory;
import com.cts.insurance.homequote.model.Location;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;

public class LocationServlet extends HttpServlet{
	
	/**
	 * Serial version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Executes the action and returns the chosen renderer
	 *
	 * @param req Http Request
	 * @param req Http Response
	 * @return renderer chosen based on the result of saving a product
	 * @throws Throwable if exception occurs while saving the product
	 */
	public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,IOException {
		final Logger logger = Logger.getLogger(this.getClass().getName());
		try {
			final HttpSession session = request.getSession();
			LocationBO locationBO = new LocationBO();
			
			//FILLED CODE 
			String page = null;
			if(session.getAttribute("location") == null)
			{	
				Location loc = new Location();
				//loc.setQuoteId(session.getAttribute(name));
				loc.setResidenceType(request.getParameter(HomeInsuranceConstants.RESIDENCE_TYPE));
				loc.setAddressLine1(request.getParameter(HomeInsuranceConstants.ADDRESS_LINE_1));
				loc.setAddressLine2(request.getParameter(HomeInsuranceConstants.ADDRESS_LINE_2));
				loc.setCity(request.getParameter(HomeInsuranceConstants.CITY));
				loc.setState(request.getParameter(HomeInsuranceConstants.STATE));
				loc.setZip(request.getParameter(HomeInsuranceConstants.ZIP));
				loc.setResidenceUse(request.getParameter(HomeInsuranceConstants.RESIDENCE_USE));
				loc.setUserName((String) session.getAttribute(HomeInsuranceConstants.USER_NAME));
				
				//locationBO.saveHomeLocation(loc);
				loc.setQuoteId(locationBO.saveHomeLocation(loc));
				session.setAttribute("location", loc);
				
				final RequestDispatcher dispatcher = request.getRequestDispatcher(HomeInsuranceConstants.HOMEOWNER_INFO);
				dispatcher.forward(request, response);	
			}
			
		} catch (Exception e) {
			//FILLED CODE 
			
			logger.error("Exception occurred while executing method LocationServlet.doPost :: " + e);
			request.setAttribute(HomeInsuranceConstants.MESSAGE, e.getMessage());
			final RequestDispatcher dispatcher = request.getRequestDispatcher(HomeInsuranceConstants.ERROR);
			dispatcher.forward(request, response);
		}
		
		
	}
}