package br.edu.ufcg.cccpharma.sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	public List<Sale> findAll(){
		return this.saleRepository.findAll();
	}

}
