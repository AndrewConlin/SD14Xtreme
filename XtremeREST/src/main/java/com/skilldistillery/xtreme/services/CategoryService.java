package com.skilldistillery.xtreme.services;

import java.util.List;

import com.skilldistillery.xtreme.entities.Category;
import com.skilldistillery.xtreme.entities.Post;

public interface CategoryService {
	List<Category> findAllCategories();
	List<Post> findAllPostsByCategory(int id);
}
