package br.edu.ufcg.cccpharma.category;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * A CategoryController object is responsible to manage the category objects of
 * the CCCPharma system based on the requests received. Once that the operations
 * are usually delegated to the service attribute, the main purposes of this
 * controller are to invoke the proper services based on the received requests
 * and to define the response status used on them.
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
@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	/**
	 * Creates a new Category object in the system and returns it after that. Also,
	 * uses the HTTP status 201.
	 * 
	 * @param category The category to be created in the system.
	 * 
	 * @return The registered Category object.
	 * 
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Category save(@RequestBody Category category) {
		return this.categoryService.save(category);
	}

	/**
	 * Returns the Sale object whose name was given as parameter. If the given name
	 * does not match one of the categories in the system, this method will return
	 * null. Also, uses the HTTP status 200.
	 * 
	 * @param name The name of the requested category.
	 * 
	 * @return The Category object whose name was given, if it exists. Null,
	 *         otherwise.
	 * 
	 */
	@GetMapping("/{name}")
	@ResponseStatus(HttpStatus.OK)
	public Category findByName(@PathVariable String name) {
		return this.categoryService.findByName(name);
	}

	/**
	 * Returns a list containing all the Category objects in the system. Uses the
	 * HTTP status 200.
	 * 
	 * @return A list of all the Categories.
	 * 
	 */
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<Category> findAll() {
		return this.categoryService.findAll();
	}

	/**
	 * Deletes the Category object whose name was given as parameter. If the given
	 * name does not match one of the categories in the system, nothing happens.
	 * Also, uses the HTTP status 200.
	 * 
	 * @param name The name of the category to be deleted.
	 * 
	 */
	@DeleteMapping("/{name}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteByName(@PathVariable String name) {
		this.categoryService.deleteByName(name);
	}

	/**
	 * Deletes all the Category objects in the system. Also, uses the HTTP status
	 * 200.
	 */
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteAll() {
		this.categoryService.deleteAll();
	}

}
