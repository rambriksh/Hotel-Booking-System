/**
 * 
 */
package com.alore.booking.service;

import com.alore.booking.model.BookingModel;
import com.alore.booking.response.Response;
 

/**
 * @author ram
 *
 */
public interface BookingService {
	public Response addBooking(BookingModel bookingmodel) throws Exception;
	public Response updateBooking(BookingModel BookingModel) throws Exception;
	public BookingModel getBooking(String booking_id) throws Exception;
}
