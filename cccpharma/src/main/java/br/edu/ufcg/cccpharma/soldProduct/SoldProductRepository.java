package br.edu.ufcg.cccpharma.soldProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldProductRepository extends JpaRepository<SoldProduct, Long> {

	SoldProduct findById(int Id);

}
