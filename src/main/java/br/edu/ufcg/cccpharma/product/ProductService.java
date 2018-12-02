package br.edu.ufcg.cccpharma.product;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A ProductService object is responsible to establish the link between the
 * ProductController and the ProductRepository. Once the controller has
 * interpreted the received requests, the service will perform all the
 * operations needed to satisfy them. When database interaction is required, the
 * ProductService will use its repository attribute.
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
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * Creates a new Product object in the system and returns it after that.
	 * 
	 * @param product The product to be created in the system.
	 * 
	 * @return The registered Product object.
	 * 
	 */
	public Product save(Product product) {
		return this.productRepository.save(product);
	}

	/**
	 * Returns the Product object whose identifier code was given as parameter. If
	 * the given code does not match one of the products in the system, this method
	 * will return null.
	 * 
	 * @param product The identifier code of the requested product.
	 * 
	 * @return The Product object whose identifier code was given, if it exists.
	 *         Null, otherwise.
	 * 
	 */
	public Product findByCode(String code) {
		return this.productRepository.findByCode(code);
	}

	/**
	 * Returns a list containing all the Product objects whose name attribute value
	 * is the name given as parameter.
	 * 
	 * @return A list of Products whose name is the one given.
	 * 
	 */

	public Product findByName(String name) {
		return this.productRepository.findByName(name);
	}

	/**
	 * Returns a list containing all the Products objects in the system.
	 * 
	 * @return A list of all the Products.
	 * 
	 */
	public Page<Product> findAll(Pageable pageRequest) {
		return this.productRepository.findAll(pageRequest);
	}

	/**
	 * Updates the Product object in the system whose identifier code is the same
	 * that the Product given as parameter and returns it after that. If the given
	 * Product does not match one of the products in the system, it will be
	 * registered and returned.
	 * 
	 * @param product The product to be updated in the system.
	 * 
	 * @return The updated (or created) Product object.
	 * 
	 */
	public Product update(Product product) {
		return this.save(product);
	}

	/**
	 * Deletes the Product object whose identifier code was given as parameter. If
	 * the given code does not match one of the products in the system, nothing
	 * happens.
	 * 
	 * @param product The identifier code of the product to be deleted.
	 * 
	 */
	public void deleteByCode(String code) {
		this.productRepository.deleteByCode(code);
	}

	/**
	 * Deletes all the Product objects in the system.
	 */
	public void deleteAll() {
		this.productRepository.deleteAll();
	}

}
