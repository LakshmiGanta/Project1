package com.app.search.service.impl;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Products;
import com.app.search.service.ProductSearchService;
import com.app.dao.ProductSearchDAO;
import com.app.dao.impl.ProductSearchDAOImpl;


public class ProductSearchServiceImpl implements ProductSearchService {
	
	private ProductSearchDAO productSearchDAO=new ProductSearchDAOImpl();
	
	@Override
	public List<Products> getProductsByProdName(String prodName) throws BusinessException {
		// TODO Auto-generated method stub
		List<Products> productList=null;
		if(prodName.matches("[a-zA-Z]{2,10}")) {
			//code here to DAO
			productList=productSearchDAO.getProductsByProdName(prodName);
		}else {
			throw new BusinessException("Invalid product name : "+prodName);
		}
		return productList;
	}
	
	@Override
	public List<Products> getProductsByMfrName(String mfrName) throws BusinessException {
		// TODO Auto-generated method stub
		List<Products> productList=null;
		if(mfrName.matches("[a-zA-Z]{2,10}")) {
			//code here to DAO
			productList=productSearchDAO.getProductsByMfrName(mfrName);
		}else {
			throw new BusinessException("Invalid mfrName name : "+mfrName);
		}
		return productList;
	}
		
	
	
	@Override
	public Products getProductsById(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Products> getProductsByCategory(String category) throws BusinessException {
		// TODO Auto-generated method stub
		List<Products> productList=null;
		if(category.matches("[a-zA-Z]{2,15}")) {
			//code here to DAO
			productList=productSearchDAO.getProductsByCategory(category);
		}else {
			throw new BusinessException("Invalid category name : "+category);
		}
		return productList;
		
	}
}
