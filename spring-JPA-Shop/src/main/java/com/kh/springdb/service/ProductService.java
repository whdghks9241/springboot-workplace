package com.kh.springdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.repository.ProductRepository;
import com.kh.springdb.vo.Product;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	// 전체조회
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	// 특정 상품 조회
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	// 저장
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
	
}

/*
 
 */