/**
 * 
 */
package com.alore.booking.mapper.booking;

import org.springframework.stereotype.Component;

import com.alore.booking.domain.BookingDomain;
import com.alore.booking.mapper.AbstractModelMapper;
import com.alore.booking.model.BookingModel;

/**
 * @author ram
 *
 */
@Component
public class BookingMapper extends AbstractModelMapper<BookingModel, BookingDomain> {

	/* (non-Javadoc)
	 * @see com.alore.booking.mapper.AbstractModelMapper#entityType()
	 */
	@Override
	public Class<BookingModel> entityType() {
		// TODO Auto-generated method stub
		return BookingModel.class;
	}

	/* (non-Javadoc)
	 * @see com.alore.booking.mapper.AbstractModelMapper#modelType()
	 */
	@Override
	public Class<BookingDomain> modelType() {
		// TODO Auto-generated method stub
		return BookingDomain.class;
	}

}
