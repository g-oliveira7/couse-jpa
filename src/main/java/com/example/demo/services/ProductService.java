package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product findById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product.get();
	}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
}
