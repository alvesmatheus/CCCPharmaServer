package br.edu.ufcg.cccpharma.sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.cccpharma.user.User;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	public List<Sale> findAll(){
		return this.saleRepository.findAll();
	}

	public Sale save(Sale sale) {
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

	public List<Sale> findbyUser(User user) {
		return this.saleRepository.findbyUser(user);
	}

}
