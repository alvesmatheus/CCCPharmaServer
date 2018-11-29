package br.edu.ufcg.cccpharma.category;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll(){
		return this.categoryRepository.findAll();
	}
	
	public Category findByName(String name) {
		return this.categoryRepository.findByName(name);
	}
	
	public Category save(Category category) {
		return this.categoryRepository.save(category);
	}
	
	public void update(String name, Category category) {
		this.categoryRepository.deleteById(name);
		this.categoryRepository.save(category);
	}
	
	public void deleteByName(String name) {
		this.categoryRepository.deleteById(name);
	}
	
	public void deleteAll() {
		this.categoryRepository.deleteAll();
	}
}