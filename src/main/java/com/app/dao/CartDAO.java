package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface CartDAO {
	
	public boolean addCart(int customerId, int productId, String productName,int quantity, int price) throws BusinessException;
	public List<Cart> viewCart(int customerId) throws BusinessException;
	public boolean emptyCart(List<Cart> cartList) throws BusinessException;;
}
