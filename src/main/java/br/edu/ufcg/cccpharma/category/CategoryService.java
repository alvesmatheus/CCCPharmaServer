package br.edu.ufcg.cccpharma.category;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category save(Category category) {
		return this.categoryRepository.save(category);
	}

	public Category findByName(String name) {
		return this.categoryRepository.findByName(name);
	}

	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}

	public void deleteByName(String name) {
		this.categoryRepository.deleteById(name);
	}

	public void deleteAll() {
		this.categoryRepository.deleteAll();
	}
}