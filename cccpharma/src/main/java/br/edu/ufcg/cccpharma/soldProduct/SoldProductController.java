package br.edu.ufcg.cccpharma.soldProduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/sold-products")
public class SoldProductController {

	@Autowired
	private SoldProductService soldProductService;

	@PostMapping
	public SoldProduct save(@RequestBody SoldProduct soldProduct) {
		return this.soldProductService.save(soldProduct);
	}

	@GetMapping("/{id}")
	public SoldProduct findById(@PathVariable long id) {
		return this.soldProductService.findById(id);
	}

	@GetMapping("/code/{productCode}")
	public List<SoldProduct> findByProductCode(@PathVariable String productCode) {
		return this.soldProductService.findByProductCode(productCode);
	}

	@GetMapping
	public List<SoldProduct> findAll() {
		return this.soldProductService.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		this.soldProductService.deleteById(id);
	}
	
	@DeleteMapping
	public void deleteAll() {
		this.soldProductService.deleteAll();
	}

}
