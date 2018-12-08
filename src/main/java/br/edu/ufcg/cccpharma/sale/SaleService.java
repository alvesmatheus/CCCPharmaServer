package br.edu.ufcg.cccpharma.sale;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ufcg.cccpharma.user.User;
import br.edu.ufcg.cccpharma.user.UserRepository;


import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * A SaleService object is responsible to establish the link between the
 * SaleController and the SaleRepository. Once the controller has interpreted
 * the received requests, the service will perform all the operations needed to
 * satisfy them. When database interaction is required, the SaleService will use
 * its repository attribute.
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
public class SaleService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SaleRepository saleRepository;

	/**
	 * Creates a new Sale object in the system and returns it after that.
	 * 
	 * @param sale The sale to be created in the system.
	 * 
	 * @return The registered Sale object.
	 * 
	 */
	public Sale save(Sale sale) {
		User user = this.userRepository.findByEmail(sale.getEmail());
		sale.setUser(user);
		sale.setCost();
		
		return this.saleRepository.save(sale);
	}

	/**
	 * Returns the Sale object whose ID number was given as parameter. If the given
	 * ID does not match one of the sales in the system, this method will return
	 * null.
	 * 
	 * @param id The ID number of the requested sale.
	 * 
	 * @return The Sale object whose ID number was given, if it exists. Null,
	 *         otherwise.
	 * 
	 */
	public Sale findById(long id) {
		return this.saleRepository.findById(id);
	}

	/**
	 * Returns a list containing all the Sale objects which user attribute value is
	 * the User whose e-mail address is the one given as parameter.
	 * 
	 * @param user The e-mail address of the User whose purchases are being
	 *             requested.
	 * 
	 * @return A list of Sales whose user is the one who possesses the e-mail
	 *         address given.
	 * 
	 */
	public List<Sale> findByUserEmail(String email) {
		return this.saleRepository.findByUserEmail(email);
	}

	/**
	 * Returns a list containing all the Sale objects in the system.
	 * 
	 * @return A list of all the Sales.
	 * 
	 */
	public Page<Sale> findAll(Pageable pageRequest) {
		return this.saleRepository.findAll(pageRequest);
	}

	/**
	 * Updates the Sale object in the system whose ID number is the same that the
	 * Sale given as parameter and returns it after that. If the given Sale does not
	 * match one of the sales in the system, it will be registered and returned.
	 * 
	 * @param sale The sale to be updated in the system.
	 * 
	 * @return The updated (or created) Sale object.
	 * 
	 */
	public Sale update(Sale sale) {
		return this.save(sale);
	}

	/**
	 * Deletes the Sale object whose ID number was given as parameter. If the given
	 * ID does not match one of the sales in the system, nothing happens.
	 * 
	 * @param id The ID number of the sale to be deleted.
	 * 
	 */
	public void deleteById(long id) {
		this.saleRepository.deleteById(id);
	}

	/**
	 * Deletes all the Sale objects in the system. Also, uses the HTTP status 200.
	 */
	public void deleteAll() {
		this.saleRepository.deleteAll();
	}

}
