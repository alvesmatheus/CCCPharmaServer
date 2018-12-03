package br.edu.ufcg.cccpharma.product;

import javax.persistence.PreUpdate;
import javax.persistence.PrePersist;

/**
 * The ProductListener object is responsible to watch events involving products
 * in the CCCPharma system and, when necessary, trigger off the proper
 * operations.
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
public class ProductListener {

	/**
	 * Sets the available attribute of the Product object given as parameter using
	 * its own amount attribute value as condition. A Product will be available only
	 * if its stock amount is higher than zero.
	 * 
	 * @param product The product whose availability must be updated.
	 * 
	 */
	@PreUpdate
	@PrePersist
	public void verifyAmount(Product product) {
		boolean available = (product.getAmount() > 0);
		product.setAvailable(available);
	}

}