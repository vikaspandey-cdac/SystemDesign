package com.design.onlinestockbrokerage.members;

public class StockPosition {
	private String symbol;
	private double quantity;
	
	public StockPosition(String symbol, double quantity) {
		super();
		this.symbol = symbol;
		this.quantity = quantity;
	}
	
	public double getQuantity() {
		return this.quantity;
	}
	

}
