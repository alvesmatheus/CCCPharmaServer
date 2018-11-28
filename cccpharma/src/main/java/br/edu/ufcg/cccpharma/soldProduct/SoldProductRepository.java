package br.edu.ufcg.cccpharma.soldProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SoldProductRepository extends JpaRepository<SoldProduct, Long> {

	SoldProduct findById(long id);

	List<SoldProduct> findByProductCode(String productCode);

}
