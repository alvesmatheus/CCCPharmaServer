package br.edu.ufcg.cccpharma.product;

import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * A ProductController object is responsible to manage the product objects of
 * the CCCPharma system based on the requests received. Once that the operations
 * are usually delegated to the service attribute, the main purposes of this
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
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * Creates a new Product object in the system and returns it after that. Also,
	 * uses the HTTP status 201.
	 * 
	 * @param product The product to be created in the system.
	 * 
	 * @return The registered Product object.
	 * 
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product save(@RequestBody Product product) {
		return this.productService.save(product);
	}

	/**
	 * Returns the Product object whose identifier code was given as parameter. If
	 * the given code does not match one of the products in the system, this method
	 * will return null. Also, uses the HTTP status 200.
	 * 
	 * @param product The identifier code of the requested product.
	 * 
	 * @return The Product object whose identifier code was given, if it exists.
	 *         Null, otherwise.
	 * 
	 */
	@GetMapping("/{code}")
	@ResponseStatus(HttpStatus.OK)
	public Product findByCode(@PathVariable String code) {
		return this.productService.findByCode(code);
	}

	/**
	 * Returns a list containing all the Product objects whose name attribute value
	 * is the name given as parameter. Uses the HTTP status 200.
	 * 
	 * @return A list of Products whose name is the one given.
	 * 
	 */
	@GetMapping("/name/{name}")
	@ResponseStatus(HttpStatus.OK)
	public Product findByName(@PathVariable String name) {
		return this.productService.findByName(name);
	}

	/**
	 * Returns a list containing all the Products objects in the system. Uses the
	 * HTTP status 200.
	 * 
	 * @return A list of all the Products.
	 * 
	 */
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<Product> findAll(Pageable pageable) {
		return this.productService.findAll(pageable);
	}

	/**
	 * Updates the Product object in the system whose identifier code is the same
	 * that the Product given as parameter and returns it after that. If the given
	 * Product does not match one of the products in the system, it will be
	 * registered and returned. Uses the HTTP status 200.
	 * 
	 * @param product The product to be updated in the system.
	 * 
	 * @return The updated (or created) Product object.
	 * 
	 */
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Product update(@RequestBody Product product) {
		return this.productService.save(product);
	}

	/**
	 * Deletes the Product object whose identifier code was given as parameter. If
	 * the given code does not match one of the products in the system, nothing
	 * happens. Also, uses the HTTP status 200.
	 * 
	 * @param product The identifier code of the product to be deleted.
	 * 
	 */
	@DeleteMapping("/{code}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteByCode(@PathVariable String code) {
		this.productService.deleteByCode(code);
	}

	/**
	 * Deletes all the Product objects in the system. Also, uses the HTTP status
	 * 200.
	 */
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteAll() {
		this.productService.deleteAll();
	}

}
