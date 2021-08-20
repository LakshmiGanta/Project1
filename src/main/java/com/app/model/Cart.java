package com.app.model;

public class Cart {

	private int customerId;
	private int productId;
	private String productName;
	private int quantity;
	private int totalPrice;
	
	public Cart() {		
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [customerId=" + customerId + ", productId=" + productId + ", productName=" + productName
				+ ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}
	public Cart(int customerId, int productId, String productName,int quantity, int totalPrice) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
	
	
}
