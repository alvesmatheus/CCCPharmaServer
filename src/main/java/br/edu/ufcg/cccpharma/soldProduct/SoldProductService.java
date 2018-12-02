package br.edu.ufcg.cccpharma.soldProduct;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufcg.cccpharma.product.Product;
import br.edu.ufcg.cccpharma.product.ProductRepository;

/**
 * A SoldProductService object is responsible to establish the link between the
 * SoldProductController and the SoldProduct and Product repositories. Once the
 * controller has interpreted the received requests, the service will perform
 * all the operations needed to satisfy them. When database interaction is
 * required, the SoldProductService will use its repositories attribute.
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
public class SoldProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SoldProductRepository soldProductRepository;

	/**
	 * Creates a new SoldProduct object in the system and returns it after that.
	 * This creation involves both Product and SoldProduct tables in the database.
	 * 
	 * @param soldProduct The sold product to be created in the system.
	 * 
	 * @return The registered SoldProduct object.
	 * 
	 */
	public SoldProduct save(SoldProduct soldProduct) {
		Product product = this.productRepository.findByCode(soldProduct.getCode());
		soldProduct.setProduct(product);

		return this.soldProductRepository.save(soldProduct);
	}

	/**
	 * Returns the SoldProduct object whose ID number was given as parameter. If the
	 * given ID does not match one of the sold products in the system, this method
	 * will return null.
	 * 
	 * @param id The ID number of the requested sold product.
	 * 
	 * @return The SoldProduct object whose ID number was given, if it exists. Null,
	 *         otherwise.
	 * 
	 */
	public SoldProduct findById(long id) {
		return this.soldProductRepository.findById(id);
	}

	/**
	 * Returns a list containing all the SoldProduct objects whose Product attribute
	 * value has the code given as parameter.
	 * 
	 * @param productCode The code of the sold products being requested.
	 * 
	 * @return A list of SoldProducts whose product code is the one given.
	 * 
	 */
	public List<SoldProduct> findByProductCode(String productCode) {
		return this.soldProductRepository.findByProductCode(productCode);
	}

	/**
	 * Returns a list containing all the SoldProduct objects in the system.
	 * 
	 * @return A list of all the SoldProducts.
	 * 
	 */
	public List<SoldProduct> findAll() {
		return this.soldProductRepository.findAll();
	}

	/**
	 * Deletes the SoldProduct object whose ID number was given as parameter. If the
	 * given ID does not match one of the sold products in the system, nothing
	 * happens. Also, uses the HTTP status 200.
	 * 
	 * @param id The ID number of the sold product to be deleted.
	 * 
	 */
	public void deleteById(long id) {
		this.soldProductRepository.deleteById(id);
	}

	/**
	 * Deletes all the SoldProduct objects in the system.
	 */
	public void deleteAll() {
		this.soldProductRepository.deleteAll();
	}

}
