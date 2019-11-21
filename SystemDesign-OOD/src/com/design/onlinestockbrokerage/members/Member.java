package com.design.onlinestockbrokerage.members;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.design.onlinestockbrokerage.StockExchange;
import com.design.onlinestockbrokerage.enums.OrderStatus;
import com.design.onlinestockbrokerage.enums.ReturnStatus;
import com.design.onlinestockbrokerage.enums.TimeEnforcementType;
import com.design.onlinestockbrokerage.orders.LimitOrder;
import com.design.onlinestockbrokerage.orders.Order;
import com.design.onlinestockbrokerage.orders.OrderPart;

public class Member extends Account {
	private double availableFundsForTrading;
	private Date dateOfMembership;

	private HashMap<String, StockPosition> stockPositions;

	private HashMap<Integer, Order> activeOrders;

	public ReturnStatus placeSellLimitOrder( String stockId, float quantity,
											int limitPrice,	TimeEnforcementType enforcementType ) {
		// check if member has this stock position
		if(!stockPositions.containsKey(stockId)) {
			return ReturnStatus.NO_STOCK_POSITION;
		}

		StockPosition stockPosition = stockPositions.get(stockId);
		// check if the member has enough quantity available to sell
		if(stockPosition.getQuantity() < quantity) {
			return ReturnStatus.INSUFFICIENT_QUANTITY;
		}

		LimitOrder order = new LimitOrder(stockId, quantity, limitPrice, enforcementType);
		order.isBuyOrder = false;
		order.saveInDB();
		boolean success = StockExchange.placeOrder(order);
		if(!success) {
			order.setStatus(OrderStatus.FAILED);
			order.saveInDB();
		} else {
			activeOrders.put(order.orderId, order);
		}
		
		return ReturnStatus.SUCCESS;
	}

	public ReturnStatus placeBuyLimitOrder(
			String stockId,
			float quantity,
			int limitPrice,
			TimeEnforcementType enforcementType)
	{
		// check if the member has enough funds to buy this stock
		if(availableFundsForTrading < quantity * limitPrice ){
			return ReturnStatus.INSUFFICIENT_FUNDS;
		}

		LimitOrder order =	new LimitOrder(stockId, quantity, limitPrice, enforcementType);
		order.isBuyOrder = true;
		order.saveInDB();
		boolean success = StockExchange.placeOrder(order);
		if(!success){
			order.setStatus(OrderStatus.FILLED);
			order.saveInDB();
		} else {
			activeOrders.put(order.orderId, order);
		}
		return ReturnStatus.SUCCESS;
	}

	// this function will be invoked whenever there is an update from
	// stock exchange against an order
	public void callbackStockExchange(int orderId, List<OrderPart> orderParts, OrderStatus status) {
		Order order = activeOrders.get(orderId);
		order.addOrderParts(orderParts);
		order.setStatus(status);
		order.updateInDB();

		if (status == OrderStatus.FILLED || status == OrderStatus.CANCELLED) {
			activeOrders.remove(orderId);
		}
	}

	@Override
	public boolean resetPassword() {
		// TODO Auto-generated method stub
		return false;
	}
}
