package com.app.model;

public class Products {
	
	private int id;
	private String prodName;
	private int noOfProds;
	private String category;
	private String mfrName;
	
	
	public Products() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	//sources--> generate tostring()
	
	@Override
	public String toString() {
		return "Products [id=" + id + ", prodName=" + prodName + ", noOfProds=" + noOfProds + ", category=" + category
				+ ", mfrName=" + mfrName + "]";
	}
	
	//sources--> generate ctor using fields
	public Products(int id, String prodName, int noOfProds, String category, String mfrName) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.noOfProds = noOfProds;
		this.category = category;
		this.mfrName = mfrName;
	}
	
	



	
	
}
