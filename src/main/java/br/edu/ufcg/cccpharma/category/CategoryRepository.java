package br.edu.ufcg.cccpharma.category;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, String> {
	
	Category findByName(String name);
	
}