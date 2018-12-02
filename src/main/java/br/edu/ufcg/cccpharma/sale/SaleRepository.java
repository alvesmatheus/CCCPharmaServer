package br.edu.ufcg.cccpharma.sale;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

	Sale findById(long Id);

	List<Sale> findByUserEmail(String email);

}
