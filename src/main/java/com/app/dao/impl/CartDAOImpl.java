package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CartDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;

public class CartDAOImpl implements CartDAO{
	
	private static Logger log = Logger.getLogger(LoginDAOImpl.class);	
	
	@Override
	public boolean addCart(int customerId, int productId, String productName,int quantity, int totalPrice) throws BusinessException {
		// TODO Auto-generated method stub
		boolean addedToCart = false;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="insert into cart (customerId,productId,productName,quantity,totalPrice) values (?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setString(3, productName);
			preparedStatement.setInt(4, quantity);
			preparedStatement.setInt(5, totalPrice);
			preparedStatement.executeUpdate();	
			addedToCart = true;
		}
		catch (ClassNotFoundException | SQLException e ) {
			// TODO: handle exception
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		
		}	
		return addedToCart;
	}

	@Override
	public List<Cart> viewCart(int customerId) throws BusinessException{	
		List<Cart> cartList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select customerId,productId,productName,quantity,totalPrice from cart where customerId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Cart cart = new Cart();
				cart.setCustomerId(resultSet.getInt("customerId"));
				cart.setProductId(resultSet.getInt("productId"));
				cart.setProductName(resultSet.getString("productName"));
				cart.setQuantity(resultSet.getInt("quantity"));
				cart.setTotalPrice(resultSet.getInt("totalPrice"));
				cartList.add(cart);
			}							
		}
		catch (ClassNotFoundException | SQLException e ) {
			// TODO: handle exception
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		
		}	
		return cartList;
	}

	@Override
	public boolean emptyCart(List<Cart> cartList) throws BusinessException {
		boolean emptyCartStatus = false;
		try(Connection connection=MySqlDbConnection.getConnection()){
			//String sql="Select prodId,prodName,noOfProds,category,mfrName,price from products where prodName=?";
			String sql = "DELETE FROM CART WHERE customerId =?";			           
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			for (Iterator<Cart> iterator = cartList.iterator(); iterator.hasNext();) {
				Cart cart = (Cart) iterator.next();
			    preparedStatement.setInt(1, cart.getCustomerId());			   			   	  
			    preparedStatement.addBatch();
			}
			//int[] updateCounts = preparedStatement.executeBatch();
			//System.out.println("update Status : "+Arrays.toString(updateCounts));
			//connection.commit();
            //connection.setAutoCommit(true);
            emptyCartStatus = true;
			
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return emptyCartStatus;
	}

	
}


























