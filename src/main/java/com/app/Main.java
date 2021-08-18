package com.app;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.model.Products;
import com.app.search.service.ProductSearchService;
import com.app.search.service.impl.ProductSearchServiceImpl;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		log.info("Welcome to Online Shopping Mall");
		log.info("==========================================");
		log.info("Main Menu");
		int ch = 0;
		do {
			log.info("1) Login As Customer");
			log.info("2) Login As Employee");
			log.info("3) Register Customer");
			log.info("4) EXIT");
			log.info("Please enter your choice(1-4)");
			
			try {
				ch = Integer.parseInt(scanner.nextLine());
			}  
				catch (NumberFormatException e) {}

			switch (ch) {
				case 1:
					log.info("Welcome to Customer Login");
					log.info("Enter UserName");
					String userName=scanner.nextLine();
					log.info("Enter Password");
					String pwd=scanner.nextLine();
					//log.info(userName);
					//log.info("Password"+" "+pwd);
						if(userName.equals("lucky") && pwd.equals("111")) {
							log.info("Login Successfull\n");
							log.info("Welcome Abc, What you wanna do today ?");	
							int value=0;
							do {
								log.info("1)Search Products");
								log.info("2)View Orders");
								log.info("3)Logout ");
								log.info("Please enter your choice(1-3)");
								try {
									value=Integer.parseInt(scanner.nextLine());
								} catch (NumberFormatException e) {
									// TODO: handle exception
								}
								switch (value) {
								case 1:
									int sp=0;
									ProductSearchService productSearchService = new ProductSearchServiceImpl();
									do {
										log.info(" Welcome to Product search");	
										log.info("you can search products from below menu");
										log.info("1)By Product Name");
										log.info("2)By Manufacturer name");
										log.info("3)By category");
										log.info("4)PreviousMenu");
										log.info("5)ViewCart");
										log.info("6)Logout");
										log.info("Please enter your choice(1-6)");
										try {
											sp=Integer.parseInt(scanner.nextLine());
										} catch (NumberFormatException e) {
											// TODO: handle exception
										}
										switch (sp) {
										case 1:
											log.info("enter the product name");	
											String prodName  = scanner.nextLine();
											try {
												List<Products> productList= productSearchService.getProductsByProdName(prodName);
												if(productList!=null && productList.size()>0) {	
													log.info("no of "+prodName+ " available are "+productList.get(0).getNoOfProds());
													Integer noProds= productList.get(0).getNoOfProds();
//													for(Products i:productList) {	
//														log.info(i);
//														log.info("no of "+prodName+ " available are "+i.getNoOfProds());
//													}	
//													for (int i = 0; i < productList.size(); i++) {
//														  
//											            log.info(productList.get(i) + " ");
//											        }
													
												}											
											}catch (BusinessException e) {
												log.warn(e.getMessage());
											}
										
											break;
										case 2:
											log.info("enter the Manufacture name");	
											String mfrName  = scanner.nextLine();
											try {
												List<Products> productList= productSearchService.getProductsByMfrName(mfrName);
												if(productList!=null && productList.size()>0) {	
													//log.info("no of "+prodName+ " available are "+productList.get(0).getNoOfProds());												
													for(Products i:productList) {	
														log.info(i);
														log.info("no of "+mfrName+ " available are "+i.getMfrName());
													}
												}
											}catch (BusinessException e) {
													// TODO: handle exception
													log.warn(e.getMessage());
												}
												
											break;
										case 3:
											log.info("enter the category name");
											String category=scanner.nextLine();
											try {
												List<Products>productlist=productSearchService.getProductsByCategory(category);
												if(productlist!=null && productlist.size()>0) {
													for(Products i:productlist) {
														log.info(i);
														log.info("no of"+category+"available are "+i.getCategory());
														
													
													}
												}
											} catch (BusinessException e) {
												// TODO: handle exception
												log.warn(e.getMessage());
											}
											break;
										case 4:
											log.info("Under Construction");
											break;
										case 5:
											log.info("Under Construction");
											break;
										case 6:
											log.info("Logout succesfull");
											break;
										}
									}while(value!=6);
									
									break;
								case 2:
									log.info("Under Construction");	
									break;

								case 3:
									log.info("LogOut is successfull ");	
									break;
								}
								
							}while(value!=3);
							
						}else {
								log.info("please enter valid username and password");
							}					
						break;
					case 2:
						log.info("Under Construction");	
						break;
					case 3:
						log.info("Under Construction");	
						break;
					case 4:
						log.info("you exited succesfully ");	
						break;
				}
		} while (ch != 4);
	}

}
