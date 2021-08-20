package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.app.dao.OrdersDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Orders;
import com.app.model.Products;

public class OrdersDAOImpl implements OrdersDAO{

	private static Logger log = Logger.getLogger(ProductSearchDAOImpl.class);
	
	@Override
	public boolean placeOrder(List<Cart> cartList) throws BusinessException {
		// TODO Auto-generated method stub
		boolean placeOrderStatus = false;
		try(Connection connection=MySqlDbConnection.getConnection()){
			//String sql="Select prodId,prodName,noOfProds,category,mfrName,price from products where prodName=?";
			String sql = "INSERT INTO ORDERS" + "  (customerId, productId, orderStatus) VALUES " +
			            " (?, ?, ?);";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			for (Iterator<Cart> iterator = cartList.iterator(); iterator.hasNext();) {
				Cart cart = (Cart) iterator.next();
			    preparedStatement.setInt(1, cart.getCustomerId());			   
			    preparedStatement.setInt(2, cart.getProductId());
			    preparedStatement.setString(3, "Ordered");			   
			    preparedStatement.addBatch();
			}
			int[] updateCounts = preparedStatement.executeBatch();
			//System.out.println("update Status : "+Arrays.toString(updateCounts));
			//connection.commit();
            //connection.setAutoCommit(true);
			placeOrderStatus = true;
			
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return placeOrderStatus;
	}

	@Override
	public List<Orders> viewOrders(int customerId) throws BusinessException {
		List<Orders> orderList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select customerId,productID,orderId,orderStatus from orders where customerId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Orders order = new Orders();
				order.setCustomerId(resultSet.getInt("customerId"));
				order.setProductId(resultSet.getInt("productId"));
				order.setOrderID(resultSet.getInt("orderId"));
				order.setOrderStatus(resultSet.getString("orderStatus"));				
				orderList.add(order);
			}							
		}
		catch (ClassNotFoundException | SQLException e ) {
			// TODO: handle exception
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		
		}	
		return orderList;
	}
	
}
