package com.app.search.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.LoginDAO;
import com.app.dao.impl.LoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.search.service.LoginService;

public class LoginServiceImpl implements LoginService{

	private static Logger log = Logger.getLogger(Main.class);
	private LoginDAO LoginDAO = new LoginDAOImpl();
	
	
	@Override
	public boolean registerCustomer(String newUserName, String newMailId, String newPwd) throws BusinessException {	
		boolean newCustReg = false;		
		newCustReg = LoginDAO.registerCustomer(newUserName, newMailId, newPwd);
		
		if(newCustReg) {
			log.info("Registered Successfully\n");
		}
		else {
			throw new BusinessException("Unable to Register.... Please Try again Later");
		}
		return newCustReg;
	}

	@Override
	public List<Customer> validateCustomer(String emailId, String password) throws BusinessException {		
		List<Customer> custList=null;
		
		custList = LoginDAO.validateCustomer(emailId, password);
		if(custList.size()==1) {
			log.info("Login Successfull\n");			
		}
		else {			
			log.info("Invalid user...\n");
			throw new BusinessException("Please try with valid Email Id and Password\n");
		}
		
		return custList;
	}

	@Override
	public boolean validateEmployee(String emailId, String password) throws BusinessException {	
		boolean empAccess = false;
		
		empAccess = LoginDAO.validateEmployee(emailId, password);
		if(empAccess) {
			log.info("access granted");
		}
		else {
			throw new BusinessException("Invalid user");
		}
		return empAccess;
	}
	

	
	
}
