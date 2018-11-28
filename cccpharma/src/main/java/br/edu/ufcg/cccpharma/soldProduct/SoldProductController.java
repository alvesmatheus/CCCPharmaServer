package br.edu.ufcg.cccpharma.soldProduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/sold_products")
public class SoldProductController {

	@Autowired
	private SoldProductService soldProductService;

	@GetMapping
	public List<SoldProduct> getSoldProducts() {
		return this.soldProductService.findAll();
	}

}
