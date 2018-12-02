package br.edu.ufcg.cccpharma.product;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class ProductListener {
	
	@PreUpdate
	@PrePersist
	public void verifyAmount(Product product) {
		if(product.getAmount() == 0) {
			product.setAvailable(false);
		}else {
			product.setAvailable(true);
		}
	}

	
	
}
