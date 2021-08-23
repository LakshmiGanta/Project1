package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.MidiDevice.Info;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customer;
import com.app.model.Orders;
import com.app.model.Products;
import com.app.search.service.CartService;
import com.app.search.service.LoginService;
import com.app.search.service.OrderService;
import com.app.search.service.ProductSearchService;
import com.app.search.service.impl.LoginServiceImpl;
import com.app.search.service.impl.OrderServiceImpl;
import com.app.search.service.impl.ProductSearchServiceImpl;
import com.app.search.service.impl.CartServiceImpl;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		DisplayFunctions  displayFunctions = new DisplayFunctions();
		log.info("Welcome to Online Shopping Mall");
		log.info("==========================================");
		log.info("Main Menu");
		int loginChoice = 0;
		do {
			log.info("1) Login As Customer");
			log.info("2) Login As Employee");
			log.info("3) Register Customer");
			log.info("4) EXIT");
			log.info("Please enter your choice(1-4)");
			
			try {
				loginChoice = Integer.parseInt(scanner.nextLine());
				displayFunctions.checkChoice(4, loginChoice);
				
			}  
			catch (NumberFormatException e) {
				log.warn(e.getMessage());
			}
			LoginService loginService = new LoginServiceImpl();
			ProductSearchService productSearchService = new ProductSearchServiceImpl();
			CartService cartService = new CartServiceImpl();
			OrderService orderService = new OrderServiceImpl();
						
			AddProductToCart addProductToCart = new AddProductToCart();
			ViewOrPlaceCart viewOrPlaceCart = new ViewOrPlaceCart();
			int customerId=0;
			String customerName="";
			switch (loginChoice) {
				case 1:
					log.info("Welcome to Customer Login");
					log.info("Enter Email Id");
					String mailId=scanner.nextLine();
					log.info("Enter Password");
					String pwd=scanner.nextLine();					
										
					boolean custGrantAccess = false;
					List<Customer> custList=null;
					
					try {
						custList = loginService.validateCustomer(mailId, pwd);
						customerId = custList.get(0).getCustomerId();
						customerName = custList.get(0).getName();
						if(custList.size()==1) {
							custGrantAccess = true;
						}	
						
					} catch (Exception e) {						
						log.warn(e.getMessage());
					}
					
						//if(userName.equals("lucky") && pwd.equals("111")) {
						if(custGrantAccess) {															
							int viewChoice=0;
							do {
								log.info("Welcome "+ customerName.toUpperCase() +", What you wanna do today ?");	
								log.info("1)Search Products");
								log.info("2)View Orders");
								log.info("3)View Cart");
								log.info("4)Logout ");
								log.info("Please enter your choice(1-4)");
								try {
									viewChoice=Integer.parseInt(scanner.nextLine());
									displayFunctions.checkChoice(4, viewChoice);
									
								} catch (NumberFormatException e) {
									log.warn(e.getMessage());
								}
								switch (viewChoice) {
								case 1:
									int searchChoice=0;
									
									do {
										log.info("\n--------------------------------------- ");
										log.info("\t Welcome to Product search");	
										log.info("---------------------------------------\n");
										log.info("you can search products from below menu");
										log.info("1)By Product Name");
										log.info("2)By Manufacturer name");
										log.info("3)By category");
										log.info("4)By Product ID");										
										log.info("5)View Cart");	
										log.info("6)PreviousMenu");
										log.info("Please enter your choice(1-6)");
										try {
											searchChoice=Integer.parseInt(scanner.nextLine());
											displayFunctions.checkChoice(6, searchChoice);											
											
										} catch (NumberFormatException e) {
											log.warn(e.getMessage());
										}
										switch (searchChoice) {
										case 1:
											log.info("Enter the Product Name : ");	
											String prodName  = scanner.nextLine();
											
											try {
												List<Products> productList= productSearchService.getProductsByProdName(prodName);																							
												addProductToCart.AddProductToCartList(productList, prodName, customerId);
																						
											}catch (BusinessException e) {
												log.info("(Please enter Name of the Product)");
												log.warn(e.getMessage());
											}											
										
											break;
										case 2:
											log.info("enter the Manufacture name");	
											String mfrName  = scanner.nextLine();
											try {
												List<Products> productList= productSearchService.getProductsByMfrName(mfrName);
												if(productList!=null && productList.size()>0) {																									
													for(Products product:productList) {	
														log.info(product);														
													}
													log.info("\nEnter the product name you want to add into Cart : ");
													String productName=scanner.nextLine();
													List<Products> productListForMFg= productSearchService.getProductsByProdName(productName);																							
													addProductToCart.AddProductToCartList(productListForMFg, productName, customerId);													
											   }
												
											}catch (BusinessException e) {													
													log.warn(e.getMessage());
											}
												
											break;
										case 3:
											log.info("Enter the category name");
											String category=scanner.nextLine();
											try {
												List<Products> productList= productSearchService.getProductsByCategory(category);
												if(productList!=null && productList.size()>0) {																									
													for(Products product:productList) {	
														log.info(product);														
													}
													log.info("\nEnter the product name you want to add into Cart : ");
													String productName=scanner.nextLine();
													List<Products> productListForMFg= productSearchService.getProductsByProdName(productName);																							
													addProductToCart.AddProductToCartList(productListForMFg, productName, customerId);													
											   }
												
											}catch (BusinessException e) {													
													log.warn(e.getMessage());
											}
											break;
										case 4:
											log.info("Enter the Product ID : ");
											int prodId  = scanner.nextInt();
											
											try {												
												List<Products> productList= productSearchService.getProductsById(prodId);
												String productName = productList.get(0).getProdName();
												addProductToCart.AddProductToCartList(productList, productName, customerId);
																						
											}catch (BusinessException e) {
												log.info("(Please entervalid product Id)");
												log.warn(e.getMessage());
											}	
											break;
										case 5:
											log.info("\n--------------------------------------- ");
											log.info("\t \t View Cart");	
											log.info("---------------------------------------\n");																									
											viewOrPlaceCart.ViewOrPlaceCartList(customerId);											
											break;	
										case 6:
											log.info("Redirecting to Previous Menu");
											break;								
										}
									
									}while(searchChoice!=6);
									log.info("please enter valid choice");
									break;
								case 2:
									log.info("View Orders");	
									//List<Orders> orderList = new ArrayList<>();
									try {
										orderService.viewOrders(customerId);
									} catch (Exception e) {
										log.warn(e.getMessage());
									}
															
									break;
								
								case 3:			
									log.info("\n--------------------------------------- ");
									log.info("\t \t View Cart");	
									log.info("---------------------------------------\n");																									
									viewOrPlaceCart.ViewOrPlaceCartList(customerId);										
																			
									break;

								case 4:
									log.info("LogOut is successfull ");	
									break;
								}
								
							}while(viewChoice!=4);
							
						}					
						break;
					case 2:						
						log.info("Login As Employee");	
						log.info("Enter Email Id");
						String emailId=scanner.nextLine();
						
						log.info("Enter Password");
						String password=scanner.nextLine();
						try {
							loginService.validateEmployee( emailId,  password);
						} catch (BusinessException e) {
							// TODO: handle exception
							log.warn(e.getMessage());
						}
						
						
						break;
					case 3:											
						log.info("-----------------------------");
						log.info("....Hello Dear Customer....");
						log.info("....Welcome to Registration Page....");
						log.info("Enter User Name");
						String newUserName=scanner.nextLine();
						
						log.info("Enter Email Id");
						String newMailId=scanner.nextLine();
						
						log.info("Enter Password");
						String newPwd=scanner.nextLine();
						
						try {
							loginService.registerCustomer(newUserName, newMailId, newPwd);							
						} catch (BusinessException e) {							
							log.warn(e.getMessage());
						}
						
						break;
					case 4:
						log.info("you exited succesfully ");	
						break;
				}
		} while (loginChoice != 4);		
		scanner.close();
	}	
}
