package br.edu.ufcg.cccpharma.sale;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * A SaleRepository object is used to create a connection with the database and
 * provide a simplified way to perform queries about products on it. The methods
 * signatures here used are self explanatory.
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
@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

	Sale findById(long Id);

	List<Sale> findByUserEmail(String email);

}
