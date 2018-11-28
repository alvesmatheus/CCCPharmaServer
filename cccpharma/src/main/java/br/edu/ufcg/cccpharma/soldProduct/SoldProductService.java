package br.edu.ufcg.cccpharma.soldProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SoldProductService {

	@Autowired
	private SoldProductRepository soldProductRepository;

	public List<SoldProduct> findAll() {
		return this.soldProductRepository.findAll();
	}

}
