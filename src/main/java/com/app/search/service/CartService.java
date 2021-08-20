package com.app.search.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface CartService {	
	
	public boolean addCart(int customerId, int productId, String productName,int quantity, int totalPrice) throws BusinessException;
	public List<Cart> viewCart(int customerId) throws BusinessException;
}
