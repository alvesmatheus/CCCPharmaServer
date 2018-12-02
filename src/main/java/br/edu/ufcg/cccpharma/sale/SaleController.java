package br.edu.ufcg.cccpharma.sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.cccpharma.user.User;

@RestController
@RequestMapping("/sale")
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Sale save(@RequestBody Sale sale) {
		return this.saleService.save(sale);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Sale update(@RequestBody Sale sale) {
		return this.saleService.save(sale);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Sale findById(@PathVariable long id) {
		return this.saleService.findById(id);
	}
	
	@GetMapping("/{user}")
	@ResponseStatus(HttpStatus.OK)
	public List<Sale> findByUser(@PathVariable User user){
		return this.saleService.findbyUser(user);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Sale> findAll(){
		return this.saleService.findAll();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable long id) {
		this.saleService.deleteById(id);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteAll() {
		this.saleService.deleteAll();
	}
	
	
}
