package br.edu.ufcg.cccpharma.category;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A CategoryService object is responsible to establish the link between the
 * CategoryController and the CategoryRepository. Once the controller has
 * interpreted the received requests, the service will perform all the
 * operations needed to satisfy them. When database interaction is required, the
 * CategoryService will use its repository attribute.
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
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * Creates a new Category object in the system and returns it after that.
	 * 
	 * @param category The category to be created in the system.
	 * 
	 * @return The registered Category object.
	 * 
	 */
	public Category save(Category category) {
		return this.categoryRepository.save(category);
	}

	/**
	 * Returns the Sale object whose name was given as parameter. If the given name
	 * does not match one of the categories in the system, this method will return
	 * null.
	 * 
	 * @param name The name of the requested category.
	 * 
	 * @return The Category object whose name was given, if it exists. Null,
	 *         otherwise.
	 * 
	 */
	public Category findByName(String name) {
		return this.categoryRepository.findByName(name);
	}

	/**
	 * Returns a list containing all the Category objects in the system.
	 * 
	 * @return A list of all the Categories.
	 * 
	 */
	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}

	/**
	 * Deletes the Category object whose name was given as parameter. If the given
	 * name does not match one of the categories in the system, nothing happens.
	 * 
	 * @param name The name of the category to be deleted.
	 * 
	 */
	public void deleteByName(String name) {
		this.categoryRepository.deleteById(name);
	}

	/**
	 * Deletes all the Category objects in the system.
	 */
	public void deleteAll() {
		this.categoryRepository.deleteAll();
	}
}