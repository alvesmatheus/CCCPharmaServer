package br.edu.ufcg.cccpharma.sale;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.cccpharma.user.User;
import br.edu.ufcg.cccpharma.user.UserRepository;

@Service
public class SaleService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SaleRepository saleRepository;
	
	public List<Sale> findAll(){
		return this.saleRepository.findAll();
	}

	public Sale save(Sale sale) {
		User user = this.userRepository.findByEmail(sale.getEmail());
		sale.setUser(user);
		sale.setCost();
		
		return this.saleRepository.save(sale);
	}

	public Sale findById(long id) {
		return this.saleRepository.findById(id);
	}

	public void deleteById(long id) {
		this.saleRepository.deleteById(id);
	}

	public void deleteAll() {
		this.saleRepository.deleteAll();
	}

	public List<Sale> findByUserEmail(String email) {
		return this.saleRepository.findByUserEmail(email);
	}

}
