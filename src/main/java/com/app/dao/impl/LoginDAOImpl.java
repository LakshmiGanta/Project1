package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.LoginDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Employee;

public class LoginDAOImpl  implements LoginDAO{

	private static Logger log = Logger.getLogger(LoginDAOImpl.class);
	
	
	@Override
	public boolean registerCustomer(String newUserName, String newMailId, String newPwd) throws BusinessException {
		// TODO Auto-generated method stub
		boolean newCustReg = false;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="insert into customer (Name,EmailId,Password) values (?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, newUserName);
			preparedStatement.setString(2, newMailId);
			preparedStatement.setString(3, newPwd);
			preparedStatement.executeUpdate();	
			connection.commit();
            connection.setAutoCommit(true);
			newCustReg = true;
		}
		catch (ClassNotFoundException | SQLException e ) {
			// TODO: handle exception
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		
		}	
		return newCustReg;
	}

	@Override
	public List<Customer> validateCustomer(String emailId, String pwd) throws BusinessException {
				
		//int custAccess=0;
		List<Customer> custList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			//log.info("connection established");
			String sql="Select CustomerId,Name,EmailId from customer where EmailId=? and Password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, emailId);
			preparedStatement.setString(2, pwd);
			ResultSet resultSet=preparedStatement.executeQuery();			
			while(resultSet.next()) {
				Customer customer =new Customer();
    			customer.setCustomerId(resultSet.getInt("CustomerId"));
				customer.setEmailId(resultSet.getString("EmailId"));
				customer.setName(resultSet.getString("Name"));
				custList.add(customer);				
			}					
		}
		catch (ClassNotFoundException | SQLException e ) {
			// TODO: handle exception
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		
		}			
		return custList;
	}

	@Override
	public boolean validateEmployee(String emailId, String pwd) throws BusinessException {
		boolean empAccess = false;
		List<Employee> employeeList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="Select Name,EmailId,EmpId from Employee where EmailId=? and Password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, emailId);
			preparedStatement.setString(2, pwd);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Employee employee =new Employee();
				employee.setEmpId(resultSet.getInt("EmpId"));
				employee.setEmailId(resultSet.getString("EmailId"));
				employee.setName(resultSet.getString("Name"));
				employeeList.add(employee);
				empAccess = true;
			}
			
		}
		catch (ClassNotFoundException | SQLException e ) {
			// TODO: handle exception
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		
		}		
		return empAccess;
	}
	
}
