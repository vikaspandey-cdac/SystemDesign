package com.design.onlinemovieticketbooking.entity;

import java.util.List;

import com.design.onlinemovieticketbooking.Booking;

public class Customer extends Person {
	public boolean makeBooking(Booking booking) {
		return false;
		
	}

	public List<Booking> getBookings(){
		return null;
		
	}
}
