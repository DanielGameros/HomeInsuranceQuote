/**
 * This Business Object class is used to for Homeowner Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cts.insurance.homequote.dao.PolicyDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Policy;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;

public class PolicyBO {
	/**
	 * @param quoteId
	 * @param policyEffectiveDate
	 * @return
	 */
	public Policy savePolicy(final int quoteId, final String policyEffDate, final int term) throws HomequoteBusinessException{
		final PolicyDAO policyDAO = new PolicyDAO();
		try
		{	
			final Policy policy = new Policy();		
			policy.setQuoteId(quoteId);
			policy.setPolicyEffDate(policyEffDate);
			policy.setPolicyEndDate(getDateAfterOneYear(policyEffDate));
			policy.setPolicyTerm(term);
			policy.setPolicyKey(quoteId + "_" + policy.getPolicyTerm());
			policy.setPolicyStatus(HomeInsuranceConstants.STATUS_ACTIVE);
			policyDAO.savePolicy(policy);
			return policy;
		}
		catch(ParseException e)
		{
			throw new HomequoteBusinessException(e.getMessage());
		}
		catch(HomequoteSystemException e)
		{
			throw new HomequoteBusinessException(e.getMessage());
		}
	}

	/**
	 * @param userName
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public List<Policy> getPolicies(final String userName) throws HomequoteBusinessException {

		final PolicyDAO policyDAO = new PolicyDAO();
		
		//FILLED CODE
		List<Policy> listOfPolicies = new ArrayList<Policy>();
		try {
			listOfPolicies.addAll(policyDAO.getPolicies(userName));
		} catch (HomequoteSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfPolicies; //return list of Object
	}
	
	/**
	 * @param policyKey
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Policy cancelPolicy(final String policyKey) throws HomequoteBusinessException {

		final PolicyDAO policyDAO = new PolicyDAO();
		Policy pol = null;
		//FILLED CODE
		try {
			pol = policyDAO.cancelPolicy(policyKey);
		} catch (HomequoteSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pol; //return Object
	}
	
	/**
	 * @param policyKey
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Policy renewPolicy(final String policyKey) throws HomequoteBusinessException {

		final PolicyDAO policyDAO = new PolicyDAO();
		Policy pol = null;
		//FILLED CODE 
		try {
			pol = policyDAO.renewPolicy(policyKey);
		} catch (HomequoteSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pol; //return Object
	}
	
	/**
	 * @param policyEffectiveDate
	 * @throws ParseException
	 */
	private String getDateAfterOneYear(final String policyEffDate) throws ParseException
	{
//		FILLED CODE
//		works if date is formatted as follows "2018-07-28 00:00:00"
//		TODO
//		In case of an Exception, 
//		throws and catch HomequoteSystemException and throw explicitly HomequoteBusinessException

		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		date =simpleDateFormat.parse(policyEffDate);
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, 1);
		Date newDate = c.getTime();
		
		String dateAfterOneYear = simpleDateFormat.format(newDate);
		return dateAfterOneYear; //return String
	}
}
