package br.edu.ufcg.cccpharma.soldProduct;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * A SoldProductController object is responsible to manage the sales of each
 * product of the CCCPharma system based on the requests received. Once that the
 * operations are usually delegated to the service attribute, the main purposes
 * of this controller are to invoke the proper services based on the received
 * requests and to define the response status used on them.
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
@RequestMapping("/sold-products")
public class SoldProductController {

	@Autowired
	private SoldProductService soldProductService;

	/**
	 * Creates a new SoldProduct object in the system and returns it after that.
	 * Also, uses the HTTP status 201.
	 * 
	 * @param soldProduct The sold product to be created in the system.
	 * 
	 * @return The registered SoldProduct object.
	 * 
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SoldProduct save(@RequestBody SoldProduct soldProduct) {
		return this.soldProductService.save(soldProduct);
	}

	/**
	 * Returns the SoldProduct object whose ID number was given as parameter. If the
	 * given ID does not match one of the sold products in the system, this method
	 * will return null. Also, uses the HTTP status 200.
	 * 
	 * @param soldProduct The ID number of the requested sold product.
	 * 
	 * @return The SoldProduct object whose ID number was given, if it exists. Null,
	 *         otherwise.
	 * 
	 */
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SoldProduct findById(@PathVariable long id) {
		return this.soldProductService.findById(id);
	}

	/**
	 * Returns a list containing all the SoldProduct objects whose Product
	 * attribute value has the code given as parameter. Uses the HTTP status 200.
	 * 
	 * @return A list of SoldProducts whose product code is the one given.
	 * 
	 */
	@GetMapping("/code/{productCode}")
	@ResponseStatus(HttpStatus.OK)
	public List<SoldProduct> findByProductCode(@PathVariable String productCode) {
		return this.soldProductService.findByProductCode(productCode);
	}

	/**
	 * Returns a list containing all the SoldProduct objects in the system. Uses the
	 * HTTP status 200.
	 * 
	 * @return A list of all the SoldProducts.
	 * 
	 */
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<SoldProduct> findAll() {
		return this.soldProductService.findAll();
	}

	/**
	 * Deletes the SoldProduct object whose ID number was given as parameter. If the
	 * given ID does not match one of the sold products in the system, nothing
	 * happens. Also, uses the HTTP status 200.
	 * 
	 * @param soldProduct The ID number of the sold product to be deleted.
	 * 
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable long id) {
		this.soldProductService.deleteById(id);
	}

	/**
	 * Deletes all the SoldProduct objects in the system. Also, uses the HTTP status
	 * 200.
	 */
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteAll() {
		this.soldProductService.deleteAll();
	}

}
