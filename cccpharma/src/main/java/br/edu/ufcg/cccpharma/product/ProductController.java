package br.edu.ufcg.cccpharma.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping
	public Product save(Product product) {
		return this.productService.save(product);
	}
	
	@PutMapping("/{code}")
	public void update(String code, Product product) {
		this.productService.deleteByCode(code);
		this.productService.save(product);
	}
	
	@GetMapping
	public List<Product> findAll(String code) {
		return this.productService.findAll();
	}
	
	@GetMapping("/{code}")
	public Product findByCode(String code) {
		return this.productService.findByCode(code);
	}
	
	@GetMapping("/{name}")
	public Product findByName(String name) {
		return this.productService.findByName(name);
	}
	
	@DeleteMapping("/{code}")
	public void deleteByCode(String code) {
		this.productService.deleteByCode(code);
	}
	
	@DeleteMapping
	public void deleteAll(Product product) {
		this.productService.deleteAll();
	}
	
}
