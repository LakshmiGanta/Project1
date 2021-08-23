package com.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public class DisplayFunctions {	
	
	private static Logger log = Logger.getLogger(Main.class);
	
	public void checkChoice(int SetValue ,int EnteredValue ) {
		if(EnteredValue > SetValue) {
			log.info("Please Enter Valid Choice \n");
		}
		
	}
	
	public void DisplayCart(List<Cart> cartList) {
		
		try {

			if(cartList.size()==0) {
				throw new BusinessException("No products available in your cart");
			}	
			
			if(cartList!=null && cartList.size()>0) {														
				for(Cart cart:cartList) {	
					log.info(cart);														
				}	
				log.info("\n");
															
			}
			
		} catch (Exception e) {
			log.warn(e.getMessage());
		}
		
	}
	

}
