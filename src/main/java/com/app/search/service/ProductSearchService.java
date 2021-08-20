package com.app.search.service;

import java.util.List;
import com.app.exception.BusinessException;
import com.app.model.Products;

public interface ProductSearchService {

	public List<Products> getProductsById(int id) throws BusinessException;
	public List<Products> getProductsByProdName(String prodName) throws BusinessException;
	public List<Products> getProductsByMfrName(String mfrName) throws BusinessException;
	public List<Products> getProductsByCategory(String category) throws BusinessException;
	
}
