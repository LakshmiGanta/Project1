package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface LoginDAO {
	
	public boolean registerCustomer(String newUserName,String newMailId, String newPwd) throws BusinessException;
	public List<Customer> validateCustomer(String emailId, String password) throws BusinessException;
	public boolean validateEmployee(String emailId, String password) throws BusinessException;
}
