package com.skilldistillery.xtreme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.xtreme.entities.Category;
import com.skilldistillery.xtreme.entities.Post;
import com.skilldistillery.xtreme.repositories.CategoryRepository;
import com.skilldistillery.xtreme.repositories.PostRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private PostRepository postRepo;
	
	@Override
	public List<Category> findAllCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public List<Post> findAllPostsByCategory(int id) {
		return postRepo.findByCategoryId(id);
	}
}
