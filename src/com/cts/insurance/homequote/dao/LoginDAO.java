/**
 * This DAO class is used to for Login Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.User;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;
import com.cts.insurance.homequote.util.SqlQueries;

public class LoginDAO {
	private final static Logger LOG = Logger.getLogger(LoginDAO.class);
	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	public User getUser(final String userName) throws HomequoteSystemException
	{
		System.out.println("getUser() method from LoginDAO invoked");
		LOG.info("LoginDAO.getUser - starts");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		User user = null;

		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
			conn = daoFactory.getConnection();
			System.out.println("Connected...");
			stmt = conn.prepareStatement(SqlQueries.SELECT_USER);
			System.out.println("SQL query prepared..");
			stmt.setString(1, userName);
			resultSet = stmt.executeQuery();
//			System.out.println(resultSet.getString(1));
			if (resultSet.next()) {
				user = new User();
				user.setUserName(resultSet.getString(1));
				user.setPassword(resultSet.getString(2));
				user.setUserRole(resultSet.getString(3));
			}
			stmt.close();
		}
		catch (SQLException e)
		{
			throw new HomequoteSystemException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new HomequoteSystemException(e.getMessage());
		} 
		finally
		{
			try
			{
				resultSet.close();
				stmt.close();
				conn.close();
			}
			catch (SQLException e)
			{
				LOG.error("Exception while trying to close Connection : " + e.getMessage() );
			}
		}
		LOG.info("LoginDAO.getUser - ends");
		return user;
	}
	
	/**
	 * @param user
	 * @throws HomequoteSystemException
	 */
	public void saveUser(final User user) throws HomequoteSystemException
	{
		System.out.println("saveUser() method from LoginDAO invoked");
		LOG.info("LoginDAO.saveUser - starts");
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
			conn = daoFactory.getConnection();
			System.out.println("Connected to database...");
			stmt = conn.prepareStatement(SqlQueries.SAVE_USER);
			System.out.println("SQL query prepared..");
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, null);
			System.out.println("username and password set");
			System.out.println("Attempting to executeUpdate()");
			stmt.executeUpdate();
			System.out.println("Success!");
			stmt.close();
		}
		catch (SQLException e)
		{
			throw new HomequoteSystemException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new HomequoteSystemException(e.getMessage());
		} 
		finally
		{
			try
			{
				stmt.close();
				conn.close();
			}
			catch (SQLException e)
			{
				LOG.error("Exception while trying to close Connection : " + e.getMessage() );
			}
		}
		LOG.info("LoginDAO.saveUser - ends");
	}
}
