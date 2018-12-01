package br.edu.ufcg.cccpharma.category;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Category save(@RequestBody Category category) {
		return this.categoryService.save(category);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Category> findAll(){
		return this.categoryService.findAll();
	}
	
	@GetMapping("/{name}")
	@ResponseStatus(HttpStatus.OK)
	public Category findByName(@PathVariable String name) {
		return this.categoryService.findByName(name);
	}
	
	@DeleteMapping("/{name}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteByName(@PathVariable String name) {
		this.categoryService.deleteByName(name);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteAll() {
		this.categoryService.deleteAll();
	}

}
