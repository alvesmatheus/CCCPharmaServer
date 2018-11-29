package br.edu.ufcg.cccpharma.product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/products")
public class ProductController {

	@PostMapping
	public Product save() {
		return null;
	}
	
	@PutMapping
	public void update() {
	}
	
	@GetMapping
	public Product findByCode() {
		return null;
	}
	
	@DeleteMapping
	public void delete() {
	}
}
