package br.edu.ufcg.cccpharma.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.cccpharma.product.Product;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getNotifications(){
		return this.notificationService.getNotifications();
	}

}
