package br.edu.ufcg.cccpharma.sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository  extends JpaRepository<Sale, Long>{
	
	Sale findById(long Id);

}
