package com.app.search.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.CartDAO;
import com.app.dao.impl.CartDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.search.service.CartService;
import com.mysql.cj.log.Log;

public class CartServiceImpl implements CartService {
	
	private static Logger log = Logger.getLogger(Main.class);
	private CartDAO cartDAO = new CartDAOImpl();

	@Override
	public boolean addCart(int customerId, int productId, String productName,int quantity, int price) throws BusinessException {
		// TODO Auto-generated method stub
		boolean addedToCart = false;
		addedToCart = cartDAO.addCart(customerId, productId, productName, quantity, price);
		if(addedToCart) {
			log.info("Product added Successfully\n");
		}else {
			log.info("Sorry....Unable to add Product.\n");
		}
		
		return addedToCart;
	}

	@Override
	public List<Cart> viewCart(int customerId) throws BusinessException{
		// TODO Auto-generated method stub
		List<Cart> cartList = new ArrayList<>();
		cartList = cartDAO.viewCart(customerId);				
		return cartList;
	}
	
	

}
