package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ProductSearchDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;

import com.app.model.Products;

import com.app.search.service.ProductSearchService;


public class ProductSearchDAOImpl implements ProductSearchDAO {
	private static Logger log = Logger.getLogger(ProductSearchDAOImpl.class);
	
	@Override
	public List<Products> getProductsByProdName(String prodName) throws BusinessException {
		// TODO Auto-generated method stub
		List<Products> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="Select prodId,prodName,noOfProds,category,mfrName,price from products where prodName=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, prodName);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Products product =new Products();
				product.setProdId(resultSet.getInt("prodId"));
				product.setProdName(resultSet.getString("prodName"));
				product.setNoOfProds(resultSet.getInt("noOfProds"));
				product.setCategory(resultSet.getString("category"));
				product.setMfrName(resultSet.getString("mfrName"));
				product.setPrice(resultSet.getInt("price"));
				productList.add(product);
			}			
			if(productList.size()==0) {
				throw new BusinessException("No products available "+prodName);
			}
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		
		return productList;
	}
	
	@Override
	public List<Products> getProductsByMfrName(String mfrName) throws BusinessException {
		
		// TODO Auto-generated method stub
		List<Products> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="Select prodId,prodName,noOfProds,category,mfrName,price from products where mfrName=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, mfrName);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Products product =new Products();
				product.setProdId(resultSet.getInt("prodId"));
				product.setProdName(resultSet.getString("prodName"));
				product.setNoOfProds(resultSet.getInt("noOfProds"));
				product.setCategory(resultSet.getString("category"));
				product.setMfrName(resultSet.getString("mfrName"));
				product.setPrice(resultSet.getInt("price"));
				productList.add(product);
			}

			if(productList.size()==0) {
				throw new BusinessException("No products available for "+mfrName+" manufacture");
			}
		}catch (ClassNotFoundException | SQLException e ) {
			// TODO: handle exception
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		
		}		
		return productList;
	}
	
	@Override
	public List<Products> getProductsById(int prodId) throws BusinessException {
		// TODO Auto-generated method stub
		List<Products> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="Select prodId,prodName,noOfProds,category,mfrName,price from products where prodId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, prodId);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Products product =new Products();
				product.setProdId(resultSet.getInt("prodId"));
				product.setProdName(resultSet.getString("prodName"));
				product.setNoOfProds(resultSet.getInt("noOfProds"));
				product.setCategory(resultSet.getString("category"));
				product.setMfrName(resultSet.getString("mfrName"));
				product.setPrice(resultSet.getInt("price"));
				productList.add(product);
			}	
			if(productList.size()==0) {
				throw new BusinessException("No products available for "+prodId+" manufacture");
			}
		}catch (ClassNotFoundException | SQLException e ) {
			// TODO: handle exception
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		
		}		
		return productList;
	}
	
	@Override
	public List<Products> getProductsByCategory(String category) throws BusinessException {
		// TODO Auto-generated method stub
		List<Products> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="Select prodId,prodName,noOfProds,category,mfrName,price from products where category=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, category);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Products product =new Products();
				product.setProdId(resultSet.getInt("prodId"));
				product.setProdName(resultSet.getString("prodName"));
				product.setNoOfProds(resultSet.getInt("noOfProds"));
				product.setCategory(resultSet.getString("category"));
				product.setMfrName(resultSet.getString("mfrName"));
				product.setPrice(resultSet.getInt("price"));
				productList.add(product);
			}

			if(productList.size()==0) {
				throw new BusinessException("No products available for "+category+" Category");
			}
		}catch (ClassNotFoundException | SQLException e ) {
			// TODO: handle exception
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		
		}		
		return productList;
	}
	
	public void updateNoOfProducts(int remProducts, int prodId ) {
		
		List<Products> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="update products set noOfProds = ? where prodId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, remProducts);
			preparedStatement.setInt(2, prodId);
			ResultSet resultSet=preparedStatement.executeQuery();
			connection.commit();
		}
		catch (Exception e) {
			// TODO: handle exception
		}	
	}
}

