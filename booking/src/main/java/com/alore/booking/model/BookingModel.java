/**
 * 
 */
package com.alore.booking.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author ram
 *
 */
@JsonInclude(Include.NON_DEFAULT)
public class BookingModel implements Serializable{
	
	private static final long serialVersionUID = 4587430320826983700L;
	
	 
	private String booking_Id;
	 
	private String country;
	 
	private String state;
	 
	private String city;
	 
	private String number_Of_Room_Avalible;
	 
	private String facilities;
 
	private String rating;

	public String getBooking_Id() {
		return booking_Id;
	}

	public void setBooking_Id(String booking_Id) {
		this.booking_Id = booking_Id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNumber_Of_Room_Avalible() {
		return number_Of_Room_Avalible;
	}

	public void setNumber_Of_Room_Avalible(String number_Of_Room_Avalible) {
		this.number_Of_Room_Avalible = number_Of_Room_Avalible;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
	 

}
