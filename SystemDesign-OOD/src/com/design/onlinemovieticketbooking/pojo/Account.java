package com.design.onlinemovieticketbooking.pojo;

import com.design.onlinemovieticketbooking.enums.AccountStatus;

public class Account {
	private String id;
	private String password;
	private AccountStatus status;

	public boolean resetPassword();
}
