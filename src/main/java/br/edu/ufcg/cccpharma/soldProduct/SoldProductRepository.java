package br.edu.ufcg.cccpharma.soldProduct;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * A SoldProductRepository object is used to create a connection with the
 * database and provide a simplified way to perform queries about sold products
 * on it. The methods signatures here used are self explanatory.
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
public interface SoldProductRepository extends JpaRepository<SoldProduct, Long> {

	SoldProduct findById(long id);

	List<SoldProduct> findByProductCode(String productCode);

}
