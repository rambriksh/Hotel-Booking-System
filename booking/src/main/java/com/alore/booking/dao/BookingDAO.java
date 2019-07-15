/**
 * 
 */
package com.alore.booking.dao;

import com.alore.booking.domain.BookingDomain;
import com.alore.booking.response.Response;
 

/**
 * @author ram
 *
 */
public interface BookingDAO {
	
	public Response addBooking(BookingDomain bookingDomain)throws Exception;
	public BookingDomain getBooking(String booking_Id)throws Exception;
	public Response updateBooking(BookingDomain bookingdomain)throws Exception;

}
