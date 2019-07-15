/**
 * 
 */
package com.alore.booking.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alore.booking.constant.StatusCode;
import com.alore.booking.dao.BookingDAO;
import com.alore.booking.model.BookingModel;
import com.alore.booking.response.ErrorObject;
import com.alore.booking.response.Response;
import com.alore.booking.service.BookingService;
import com.alore.booking.utils.CommonUtils;
 
 
 

/**
 * @author ram
 *
 */

@RestController
@RequestMapping("/145")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class BookingController {
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired 
	BookingService bookingservice;
	
	@Autowired 
	BookingDAO bookingDAO;
	
	
	@RequestMapping(value = "/booking", method = RequestMethod.POST, produces = "application/json")
	public Response addBooking(@RequestBody BookingModel bookingModel, HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		logger.info("addParent: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addUser: Received request: "+ CommonUtils.getJson(bookingModel));
		
		return bookingservice.addBooking(bookingModel);
		
	}

	
	
	@RequestMapping(value = "/getBooking/{BookingId}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody String getBooking(@PathVariable("bookingId") String bookingId, HttpServletRequest request,
		HttpServletResponse response) throws Exception 
{

	logger.info("getBooking: Received request: " + request.getRequestURL().toString()
			+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	
	BookingModel bookingModel = bookingservice.getBooking( bookingId);
	
	 Response res = CommonUtils.getResponseObject("Booking Details");
	if (bookingModel == null)
	{
		ErrorObject err = CommonUtils.getErrorResponse("Parents Not Found", "Parents Not Found");
		res.setErrors(err);
		res.setStatus(StatusCode.ERROR.name());
	} 
	else
	{
		res.setData(bookingModel);
	}
	logger.info("getParent: Sent response");
	return CommonUtils.getJson(res);
}
	
	
	
	@RequestMapping(value = "/updateBooking", method = RequestMethod.PUT, produces = "application/json")
	public Response updateBooking(@RequestBody BookingModel bookingModel, HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		logger.info("updateBooking: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateBooking: Received request: " + CommonUtils.getJson(bookingModel));
		
		return bookingservice.updateBooking(bookingModel);
		
	}
	
	
	
 
}
