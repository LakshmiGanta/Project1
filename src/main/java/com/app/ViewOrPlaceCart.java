package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.search.service.CartService;
import com.app.search.service.OrderService;
import com.app.search.service.impl.CartServiceImpl;
import com.app.search.service.impl.OrderServiceImpl;

public class ViewOrPlaceCart{
	private static Logger log = Logger.getLogger(Main.class);
	Scanner scanner = new Scanner(System.in);
	
	CartService cartService = new CartServiceImpl();
	OrderService orderService = new OrderServiceImpl();
	
	List<Cart> cartList = new ArrayList<>();
	
	public void ViewOrPlaceCartList(int customerId) {
		
		int orderChoice=0;
		try {												
			cartList = cartService.viewCart(customerId);
			
			if(cartList.size()==0) {
				throw new BusinessException("No products available in your cart");
			}			
			if(cartList!=null && cartList.size()>0) {														
				for(Cart cart:cartList) {	
					log.info(cart);														
				}	
				log.info("\n");
															
			}
			
			log.info("Do u want to place order.. For placing order select ");
			log.info("1) Yes");
			log.info("2) NO");
			orderChoice = Integer.parseInt(scanner.nextLine());
			switch (orderChoice) {
			case 1:	
				orderService.placeOrder(cartList);											
				log.info("You can view the status of the order in Main Menu --> View Orders Section");
				log.info("Thanks for Shopping.. ");											
				break;
			case 2:
				log.info("Keep Shopping");
				break;
			}											
		} catch (Exception e) {
			log.warn(e.getMessage());
		}
		
	}

}
