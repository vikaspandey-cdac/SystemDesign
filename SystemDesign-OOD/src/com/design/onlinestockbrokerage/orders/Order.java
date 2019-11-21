package com.design.onlinestockbrokerage.orders;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.design.onlinestockbrokerage.enums.OrderStatus;
import com.design.onlinestockbrokerage.enums.TimeEnforcementType;

public abstract class Order {
	public int orderId;
	private String orderNumber;
	public boolean isBuyOrder;
	private OrderStatus status;
	private TimeEnforcementType timeEnforcement;
	private Date creationTime;

	private HashMap<Integer, OrderPart> parts;

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public boolean saveInDB() {
		return isBuyOrder;
		// save in the database
	}

	public void addOrderParts(List<OrderPart> parts) {
		for (OrderPart part : parts) {
			this.parts.put(part.id, part);
		}
	}

	public void updateInDB() {
		// TODO Auto-generated method stub
		
	}
}
