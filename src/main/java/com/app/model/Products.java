package com.app.model;

public class Products {
	
	private int prodId;
	private String prodName;
	private int noOfProds;
	private String category;
	private String mfrName;
	private int price;
	
	public Products() {
		
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getNoOfProds() {
		return noOfProds;
	}

	public void setNoOfProds(int noOfProds) {
		this.noOfProds = noOfProds;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMfrName() {
		return mfrName;
	}

	public void setMfrName(String mfrName) {
		this.mfrName = mfrName;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
	//sources--> generate tostring()
	
	@Override
	public String toString() {
		return "Products [Product ID = " + prodId + ", Product Name = " + prodName + ", Products Available =" + noOfProds + ", Category = " + category
				+ ", Manufacturer Name = " + mfrName + ", Item Price = " + price + "]";
	}

	public Products(int prodId, String prodName, int noOfProds, String category, String mfrName, int price) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.noOfProds = noOfProds;
		this.category = category;
		this.mfrName = mfrName;
		this.price = price;
	}

	
	
	
	
	
}
