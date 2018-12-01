package br.edu.ufcg.cccpharma.sale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufcg.cccpharma.user.User;

@Repository
public interface SaleRepository  extends JpaRepository<Sale, Long>{
	
	Sale findById(long Id);

	List<Sale> findbyUser(User user);

}
