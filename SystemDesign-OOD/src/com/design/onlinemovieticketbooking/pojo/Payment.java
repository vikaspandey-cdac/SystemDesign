package com.design.onlinemovieticketbooking.pojo;

import java.util.Date;

import com.design.onlinemovieticketbooking.enums.PaymentStatus;

public class Payment {
	private double amount;
	private Date createdOn;
	private int transactionId;
	private PaymentStatus status;
}
