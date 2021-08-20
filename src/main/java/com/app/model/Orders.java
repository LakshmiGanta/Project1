package com.app.model;

public class Orders {

	private int customerId;
	private int productId;
    private int orderID;
    private String orderStatus;
    
    public Orders() {
    	
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Orders [customerId=" + customerId + ", productId=" + productId +", orderID=" + orderID + ", orderStatus=" + orderStatus + "]";
	}
	public Orders(int customerId, int productId, String productName, int orderID, String orderStatus) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.orderID = orderID;
		this.orderStatus = orderStatus;
	}

}
