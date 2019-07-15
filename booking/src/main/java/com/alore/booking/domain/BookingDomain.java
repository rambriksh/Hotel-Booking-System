/**
 * 
 */
package com.alore.booking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ram
 *
 */


@Entity
@Table(name ="Booking1")

public class BookingDomain implements Serializable{
	private static final long serialVersionUID = -2585956794138390018L;
	
	@Id
	@Column(name="booking_Id")
	private String booking_Id;
	@Column(name="country")
	private String country;
	@Column(name="state")
	private String state;
	@Column(name="city")
	private String city;
	@Column(name="number_Of_Room_Avalible")
	private String number_Of_Room_Avalible;
	@JoinColumn(name="facilities")
	private String facilities;
	@Column(name="rating")
	private String rating;
	@Column(name="isActive")
	private boolean isActive;
	 
	
	 
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BookingDomain(String booking_Id, String country, String state, String city, String number_Of_Room_Avalible,String facilities,
			String rating,boolean isActive) {
		super();
		this.booking_Id = booking_Id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.number_Of_Room_Avalible = number_Of_Room_Avalible;
		this.facilities= facilities;
		this.rating=rating;
		this.isActive = isActive;
	}
	public BookingDomain() {
		super();
	}
	BookingDomain(String booking_Id, String country, String state, String city, String number_Of_Room_Avalible,String facilities,
			String rating) {
			super();
			
			this.booking_Id = booking_Id;
			this.country = country;
			this.state = state;
			this.city = city;
			this.number_Of_Room_Avalible = number_Of_Room_Avalible;
			this.facilities= facilities;
			
		}
	


}
