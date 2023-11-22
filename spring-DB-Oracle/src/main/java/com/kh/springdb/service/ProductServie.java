package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.mapper.ProductMapper;
import com.kh.springdb.model.Product;

@Service
public class ProductServie {
	/*
		JPA 
		@Autowired
		private ProductRepository productRepository;
	*/
	@Autowired
	private ProductMapper productMapper;
	
	public List<Product> getAllProducts(){
		//return productRepository.findAll();
		return productMapper.getAllProducts();
	}
	
}





