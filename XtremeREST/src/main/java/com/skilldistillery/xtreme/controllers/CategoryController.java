package com.skilldistillery.xtreme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.xtreme.entities.Category;
import com.skilldistillery.xtreme.entities.Post;
import com.skilldistillery.xtreme.services.CategoryService;

@RestController
@RequestMapping("api")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(path="categories", method=RequestMethod.GET)
	public List<Category> index(){
		return categoryService.findAllCategories();
	}
	
	@RequestMapping(path="categories/{id}/posts", method=RequestMethod.GET)
	public List<Post> findPostsByCategory(@PathVariable int id){
		return categoryService.findAllPostsByCategory(id);
	}
	
	
}
