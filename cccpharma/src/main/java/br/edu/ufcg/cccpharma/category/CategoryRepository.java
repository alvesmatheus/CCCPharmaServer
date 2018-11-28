package br.edu.ufcg.cccpharma.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
	
	Category findByName(String name);

}
