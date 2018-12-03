package br.edu.ufcg.cccpharma.product;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * A ProductRepository object is used to create a connection with the database
 * and provide a simplified way to perform queries about products on it. The
 * methods signatures here used are self explanatory.
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
public interface ProductRepository extends JpaRepository<Product, String> {

	Product findByCode(String code);

	Product findByName(String name);

	void deleteByCode(String code);

	List<Product> findTop10ByAmountLessThan(int quantity);
}
