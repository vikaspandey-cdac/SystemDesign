package com.design.onlinestockbrokerage.orders;

import com.design.onlinestockbrokerage.enums.TimeEnforcementType;

public class LimitOrder extends Order {
	
	public LimitOrder(String stockId, float quantity, int limitPrice, TimeEnforcementType enforcementType) {
		// TODO Auto-generated constructor stub
	}

	private double priceLimit;
}
