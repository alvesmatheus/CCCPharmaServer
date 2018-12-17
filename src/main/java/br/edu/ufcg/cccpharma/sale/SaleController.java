package br.edu.ufcg.cccpharma.sale;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.cccpharma.product.Product;
import br.edu.ufcg.cccpharma.product.ProductService;
import br.edu.ufcg.cccpharma.soldProduct.SoldProduct;

/**
 * A SaleController object is responsible to manage the sale objects of the
 * CCCPharma system based on the requests received. Once that the operations are
 * usually delegated to the service attribute, the main purposes of this
 * controller are to invoke the proper services based on the received requests
 * and to define the response status used on them.
 * 
 * @author Douglas Pereira de Lima
 * @author Fanny Batista Vieira
 * @author Mateus de Lima Oliveira
 * @author Matheus Alves dos Santos
 * 
 * @since 2018-11-12
 * @version 1.0
 * 
 */
@RestController
@RequestMapping("/sales")
public class SaleController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private SaleService saleService;

	/**
	 * Creates a new Sale object in the system and returns it after that. Also, uses
	 * the HTTP status 201.
	 * 
	 * @param sale The sale to be created in the system.
	 * 
	 * @return The registered Sale object.
	 * 
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Sale save(@RequestBody Sale sale) {
		this.decrementProductQuantity(sale.getSoldProducts());
		return this.saleService.save(sale);
	}

	/**
	 * Returns the Sale object whose ID number was given as parameter. If the given
	 * ID does not match one of the sales in the system, this method will return
	 * null. Also, uses the HTTP status 200.
	 * 
	 * @param id The ID number of the requested sale.
	 * 
	 * @return The Sale object whose ID number was given, if it exists. Null,
	 *         otherwise.
	 * 
	 */
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Sale findById(@PathVariable long id) {
		return this.saleService.findById(id);
	}


	/**
	 * Returns a list containing all the Sale objects in the system. Uses the HTTP
	 * status 200.
	 * 
	 * @return A list of all the Sales.
	 * 
	 */
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<Sale> findAll(Pageable pageable) {
		return this.saleService.findAll(pageable);
	}

	/**
	 * Updates the Sale object in the system whose ID number is the same that the
	 * Sale given as parameter and returns it after that. If the given Sale does not
	 * match one of the sales in the system, it will be registered and returned.
	 * Uses the HTTP status 200.
	 * 
	 * @param sale The sale to be updated in the system.
	 * 
	 * @return The updated (or created) Sale object.
	 * 
	 */
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Sale update(@RequestBody Sale sale) {
		return this.saleService.update(sale);
	}

	/**
	 * Deletes the Sale object whose ID number was given as parameter. If the given
	 * ID does not match one of the sales in the system, nothing happens. Also, uses
	 * the HTTP status 200.
	 * 
	 * @param id The ID number of the sale to be deleted.
	 * 
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable long id) {
		this.findById(id).incrementProductQuantity();
		this.saleService.deleteById(id);
	}

	/**
	 * Deletes all the Sale objects in the system. Also, uses the HTTP status 200.
	 */
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteAll() {
		this.saleService.deleteAll();
	}
	
	/**
	 * 
	 * Decrement the quantity of each product in one Sale. It gets the current amount 
	 * of a product and decrement the quantity of that product that is going to be in this sale.
	 *  
	 */
	private void decrementProductQuantity(Set<SoldProduct> soldProducts) {
		for (SoldProduct soldProduct : soldProducts) {
			int amount = soldProduct.getProduct().getAmount() - soldProduct.getQuantity();
			Product product = soldProduct.getProduct();
			product.setAmount(amount);
			
			productService.update(product);
		}
	}

}
