package com.app;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.model.Products;
import com.app.search.service.CartService;
import com.app.search.service.impl.CartServiceImpl;

public class AddProductToCart {
	
	private static Logger log = Logger.getLogger(Main.class);
	Scanner scanner = new Scanner(System.in);
	CartService cartService = new CartServiceImpl();
	
	public AddProductToCart() {
		// TODO Auto-generated constructor stub
	}	
	public void AddProductToCartList(List<Products> productList, String prodName, int customerId) {
		
		if(productList!=null && productList.size()>0) {														
			for(Products i:productList) {	
				log.info(i);														
			}						
			int prodAvailable = productList.get(0).getNoOfProds();
			log.info("\nNumber of "+prodName+ " available are "+ prodAvailable);
			
			int choice=0;
			do {
				log.info("1)Enter 1 to add product into cart");
				log.info("2)GO to previous menu");
				log.info("Please enter your choice");
				try {
					choice=Integer.parseInt(scanner.nextLine());
					
					switch (choice) {
					case 1:		
						log.info("Enter the Number of products you want to add in cart");
						int quantity = scanner.nextInt();
						int productId = productList.get(0).getProdId();																
						int price = productList.get(0).getPrice();	
						int totalPrice =0;
						if(quantity > prodAvailable) {
							log.info("Please select "+ prodName + " less than or equal to " + prodAvailable );							
							int quantity2 = scanner.nextInt();
							totalPrice = quantity2 * price;
							try {
								cartService.addCart(customerId, productId, prodName, quantity, totalPrice);
							} catch (Exception e) {
								log.warn(e.getMessage());
							}
						}
						else {																				
							totalPrice = quantity * price;
							try {
								cartService.addCart(customerId, productId, prodName, quantity, totalPrice);
							} catch (Exception e) {
								log.warn(e.getMessage());
							}															
						}
																					
						break;
					case 2:	
						log.info("Redirecting to Previous Menu");
						break;
						
					}
				
				} catch (NumberFormatException  e ) {
					log.warn(e.getMessage());
					
				}
				
			}while(choice!=1);
			
		 }	
		
	}
}
