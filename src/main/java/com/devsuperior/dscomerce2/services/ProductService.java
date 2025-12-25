package com.devsuperior.dscomerce2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(Pageable pageable) {
		
		Page<Product> result =  repository.findAll(pageable);
		
		return result.map(x -> new ProductDTO(x));
				
	}
	

}
