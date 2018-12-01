package br.edu.ufcg.cccpharma.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	
	public Product save(Product product) {
		return this.productRepository.save(product);
	}
		
	public Page<Product> findAll(Pageable pageRequest) {
		return this.productRepository.findAll(pageRequest);
	}
	
	public Product findByCode(String code) {
		return this.productRepository.findByCode(code);
	}
	
	public Product findByName(String name) {
		return this.productRepository.findByName(name);
	}
	
	public void deleteAll() {
		this.productRepository.deleteAll();
	}
	
	public void deleteByCode(String code) {
		this.productRepository.deleteByCode(code);
	}
	
}
