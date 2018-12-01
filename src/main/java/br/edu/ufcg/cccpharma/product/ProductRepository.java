package br.edu.ufcg.cccpharma.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	Product findByName(String name);
	
	Product findByCode(String code);
	
	void deleteByCode(String code);	
	
	List<Product> findTop10ByAmountLessThan(int quantity);
}
