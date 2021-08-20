package com.app.search.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.CartDAO;
import com.app.dao.OrdersDAO;
import com.app.dao.impl.CartDAOImpl;
import com.app.dao.impl.OrdersDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Orders;
import com.app.search.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	private static Logger log = Logger.getLogger(Main.class);
	private OrdersDAO ordersDAO = new OrdersDAOImpl();
	private CartDAO cartDAO = new CartDAOImpl();
	
	
	@Override
	public boolean placeOrder(List<Cart> cartList) throws BusinessException {
		// TODO Auto-generated method stub
		boolean placeOrderStatus = false;
		boolean cartStatus =false;
		if(cartList.size()>0 && cartList!=null) {
			placeOrderStatus = ordersDAO.placeOrder(cartList);
			if(placeOrderStatus) {
				log.info("Order Placed Successfully..");				
				cartStatus = cartDAO.emptyCart(cartList);
				if(cartStatus) {
					log.info("Now Cart is Empty");	
					log.info("Keep Shopping.....\n");	
				}
			}
			else {
				log.info("Order not placed..");
			}
		}else {
			log.info("There is nothing to place in Cart..");
			log.info("Please add products into Cart");
		}
				
		return placeOrderStatus;
	}


	@Override
	public void viewOrders(int customerId) throws BusinessException {
		List<Orders> orderList = new ArrayList<>();
		orderList = ordersDAO.viewOrders(customerId);	
		try {			
			if(orderList.size()==0) {
				log.info("You haven't order anything till now");	
				log.info("Please add some products to cart and place order");
				throw new BusinessException();											
			}			
			if(orderList!=null && orderList.size()>0) {														
				for(Orders order:orderList) {	
					log.info(order);														
				}	
				log.info("\n");
															
			}
			
			
		} catch (Exception e) {
			log.warn(e.getMessage());
		}			
		//return orderList;
	}

}
