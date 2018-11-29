package br.edu.ufcg.cccpharma.product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	private ProductRepository productRepository;

	
	public Product save(Product product) {
		return this.productRepository.save(product);
	}
	
	public void update(String code, Product product) {
		this.productRepository.deleteById(code);
		this.productRepository.save(product);
	}
	
	public Product findByCode(String code) {
		return this.productRepository.findByCode(code);
	}
	
	public void delete() {
	}
	

}
