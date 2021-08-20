package com.app.model;

public class Employee {
	
	private int empId;	
	private String name;
	private String emailId;
	private String password;
	
	public Employee() {
		
	}
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee(int empId, String name, String emailId, String password) {
		super();
		this.empId = empId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
	}
	
	
}
