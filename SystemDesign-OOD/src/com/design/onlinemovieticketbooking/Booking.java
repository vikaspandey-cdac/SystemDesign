package com.design.onlinemovieticketbooking;

import java.util.Date;
import java.util.List;

import com.design.onlinemovieticketbooking.enums.BookingStatus;
import com.design.onlinemovieticketbooking.pojo.Payment;
import com.design.onlinemovieticketbooking.pojo.Show;
import com.design.onlinemovieticketbooking.pojo.ShowSeat;

public class Booking {
	private String bookingNumber;
	private int numberOfSeats;
	private Date createdOn;
	private BookingStatus status;

	private Show show;
	private List<ShowSeat> seats;
	private Payment payment;

	public boolean makePayment(Payment payment) {
		return false;
		
	}

	public boolean cancel() {
		return false;
		
	}

	public boolean assignSeats(List<ShowSeat> seats) {
		return false;
		
	}
}
