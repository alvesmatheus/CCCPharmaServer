package br.edu.ufcg.cccpharma.category;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<Category> getCategories(){
		return this.categoryService.findAll();
	}
	
	@GetMapping("/{name}")
	public Category findByName(String name) {
		return this.categoryService.findByName(name);
	}
	
	@PostMapping
	public Category save(@RequestBody Category category) {
		return this.categoryService.save(category);
	}
	
	@PutMapping("/{name}")
	public void update(@PathVariable String name, @RequestBody Category category) {
		this.categoryService.update(name, category);
	}
	
	@DeleteMapping("/{name}")
	public void deleteByName(String name) {
		this.categoryService.deleteByName(name);
	}
	
	@DeleteMapping
	public void deleteAll() {
		this.categoryService.deleteAll();
	}

}
