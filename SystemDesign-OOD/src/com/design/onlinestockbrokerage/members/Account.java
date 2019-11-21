package com.design.onlinestockbrokerage.members;

import com.design.onlinestockbrokerage.enums.AccountStatus;
import com.design.onlinestockbrokerage.loco.Location;

public abstract class Account {
	private String id;
	private String password;
	private String name;
	private AccountStatus status;
	private Location address;
	private String email;
	private String phone;

	public abstract boolean resetPassword();
}
