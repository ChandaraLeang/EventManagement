package mum.ea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mum.ea.domain.Category;
import mum.ea.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/categories")
	public List<Category> getCategories() {
		return categoryService.getAllCategories();
	}
	
	@RequestMapping("/categories/{id}")
	public Category getCategory(@PathVariable int id) {
		return categoryService.getCategory(id);
	}
}