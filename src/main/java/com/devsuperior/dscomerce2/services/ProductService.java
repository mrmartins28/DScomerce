package com.devsuperior.dscomerce2.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscomerce2.dto.ProductDTO;
import com.devsuperior.dscomerce2.entities.Product;
import com.devsuperior.dscomerce2.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		
		Optional<Product> result = repository.findById(id);
		Product product = result.get();
		
		return new ProductDTO(product);
	}
	

}
