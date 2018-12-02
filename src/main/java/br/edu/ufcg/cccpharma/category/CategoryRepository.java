package br.edu.ufcg.cccpharma.category;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * A CategoryRepository object is used to create a connection with the database
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
@Transactional
public interface CategoryRepository extends JpaRepository<Category, String> {

	Category findByName(String name);

}