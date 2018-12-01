package br.edu.ufcg.cccpharma.sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public List<Sale> getSales(){
		return this.saleService.findAll();
	}
}
