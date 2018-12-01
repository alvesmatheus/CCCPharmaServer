package br.edu.ufcg.cccpharma.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.cccpharma.product.Product;
import br.edu.ufcg.cccpharma.product.ProductRepository;

@Service
public class NotificationService {
	
	public static final int PRODUCT_LOW_AMOUNT = 15;

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getNotifications(){
		return this.productRepository.findTop10ByAmountLessThan(PRODUCT_LOW_AMOUNT);
	}
		
}
