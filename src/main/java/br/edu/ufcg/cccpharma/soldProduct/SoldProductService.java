package br.edu.ufcg.cccpharma.soldProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldProductService {
		
	@Autowired
	private SoldProductRepository soldProductRepository;

	public SoldProduct save(SoldProduct soldProduct) {
		return this.soldProductRepository.save(soldProduct);
	}

	public SoldProduct findById(long id) {
		return this.soldProductRepository.findById(id);
	}

	public List<SoldProduct> findByProductCode(String productCode) {
		return this.soldProductRepository.findByProductCode(productCode);
	}

	public List<SoldProduct> findAll() {
		return this.soldProductRepository.findAll();
	}
	
	public void deleteById(long id) {
		this.soldProductRepository.deleteById(id);
	}
	
	public void deleteAll() {
		this.soldProductRepository.deleteAll();
	}

}
