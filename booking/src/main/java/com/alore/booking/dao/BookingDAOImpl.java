/**
 * 
 */
package com.alore.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alore.booking.constant.StatusCode;
import com.alore.booking.domain.BookingDomain;
import com.alore.booking.response.Response;
import com.alore.booking.utils.CommonUtils;
 
 

/**
 * @author ram
 *
 */
@Repository
@Transactional
public class BookingDAOImpl implements BookingDAO {
	private static final Logger logger = LoggerFactory.getLogger(BookingDAOImpl.class);

	/* (non-Javadoc)
	 * @see com.alore.booking.dao.BookingDAO#addPriority(com.alore.booking.domain.BookingDomain)
	 */
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public Response addBooking(BookingDomain bookingDomain) throws Exception {
		// TODO Auto-generated method stub
		Response response = CommonUtils.getResponseObject("Add booking data");
		try 
		{  
			entityManager.persist(bookingDomain);
			response.setStatus(StatusCode.SUCCESS.name());
		} 
		catch (Exception e) 
		 
		{
			logger.error("Exception in addUser", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;	}


	@Override
	public BookingDomain getBooking(String booking_Id) throws Exception {
		try 
		{
			String hql = "From BookingDomain where id=?1 and isActive=true";
			return (BookingDomain) entityManager.createQuery(hql).setParameter(1, booking_Id).getSingleResult();
		} 
		catch (EmptyResultDataAccessException e) 
		{
			return null;
		} 
		catch (Exception e) 
		{
			logger.error("Exception in getBooking"+ e.getMessage());
			return null;
		}
	}


	@Override
	public Response updateBooking(BookingDomain bookingdomain) throws Exception {
		// TODO Auto-generated method stub
		Response response = CommonUtils.getResponseObject("Update Booking data");
		try 
		{	
			BookingDomain bookingDomains = getBooking(bookingdomain.getBooking_Id());
			bookingDomains.setCountry(bookingdomain.getCountry());
			bookingDomains.setState(bookingdomain.getState());
			bookingDomains.setCity(bookingdomain.getCity());
			bookingDomains.setNumber_Of_Room_Avalible(bookingdomain.getNumber_Of_Room_Avalible());
			bookingDomains.setFacilities(bookingdomain.getFacilities());
			bookingDomains.setRating(bookingdomain.getRating());
			bookingDomains.setActive(true);
	        entityManager.flush();
			response.setStatus(StatusCode.SUCCESS.name());
		} 
		catch 	(Exception e) 
		{
			logger.error("Exception in updateParent", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return  response;
	}

}
