package com.app.search.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Orders;

public interface OrderService {
	
	public boolean placeOrder(List<Cart> cartList) throws BusinessException;
	//public List<Orders> viewOrders(int customerId) throws BusinessException;
	public void viewOrders(int customerId) throws BusinessException;
}
