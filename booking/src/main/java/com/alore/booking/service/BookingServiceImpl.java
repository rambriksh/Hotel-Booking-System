/**
 * 
 */
package com.alore.booking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alore.booking.constant.StatusCode;
import com.alore.booking.dao.BookingDAO;
import com.alore.booking.domain.BookingDomain;
import com.alore.booking.mapper.booking.BookingMapper;
import com.alore.booking.model.BookingModel;
import com.alore.booking.response.Response;
import com.alore.booking.utils.CommonUtils;
 
 

 

/**
 * @author ram
 *
 */
@Service
public class BookingServiceImpl implements BookingService {

	private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
	@Autowired
	BookingDAO bookingdao;
	
	@Autowired
	BookingMapper bookingmapper;

	/* (non-Javadoc)
	 * @see com.alore.booking.service.BookingService#addPriority(com.alore.booking.model.BookingModel)
	 */
	@Override
	public Response addBooking(BookingModel bookingmodel) throws Exception {
		// TODO Auto-generated method stub
try{
			
			
			 
			BookingDomain bookingdomain= new BookingDomain();
			bookingdomain.setBooking_Id(CommonUtils.generateRandomId());
			bookingdomain.setCountry(bookingmodel.getCountry());
			 bookingdomain.setState(bookingmodel.getState());
			 bookingdomain.setCity(bookingmodel.getCity());
			 bookingdomain.setNumber_Of_Room_Avalible(bookingmodel.getNumber_Of_Room_Avalible());
			 bookingdomain.setFacilities(bookingmodel.getFacilities());
			 bookingdomain.setRating(bookingmodel.getRating());
			 bookingdomain.setActive(true);
		
			 
		 
			
			
			
			 Response response = bookingdao.addBooking(bookingdomain);
				return response;
			
		}catch(Exception e){
			
			
			logger.info("Exception Service:" + e.getMessage());
			Response response=new Response();
			response.setStatus(StatusCode.ERROR.name());
			response.setMessage(e.getMessage());
			return response;
			
		}
	
	
	}

	@Override
	public Response updateBooking(BookingModel BookingModel) throws Exception {
		// TODO Auto-generated method stub
		{
			BookingDomain bookingDomai=new BookingDomain();
			BeanUtils.copyProperties(BookingModel, bookingDomai);
			Response res=bookingdao.updateBooking(bookingDomai);
			return res;
		}
	}

	@Override
	public BookingModel getBooking(String booking_id) throws Exception {
		// TODO Auto-generated method stub
		try 
		{
			BookingModel bookingModel = new BookingModel();
			BookingDomain bookingDomain = bookingdao.getBooking(booking_id);
			BeanUtils.copyProperties(bookingDomain, bookingModel);
			return bookingModel;
		} 
		catch(Exception e) 
		{
			logger.info("Exception getbooking:", e);
			return null;
		}
	}
}
