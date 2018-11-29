package br.edu.ufcg.cccpharma.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	
	public Product save(Product product) {
		return this.productRepository.save(product);
	}
	
	public void update(String code, Product product) {
		this.productRepository.deleteById(code);
		this.productRepository.save(product);
	}
	
	public List<Product> findAll() {
		return this.productRepository.findAll();
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
