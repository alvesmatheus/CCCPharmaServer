package br.edu.ufcg.cccpharma.product;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class ProductListener {
	
	@PostUpdate
	@PostPersist
	public void verifyAmount(Product product) {
		if(product.getAmount() == 0) {
			product.setAvailable(false);
		}
	}
}
