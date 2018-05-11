package com.skilldistillery.xtreme.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.xtreme.entities.Post;

@Transactional
@Service
public class PostDAOImpl implements PostDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Post> index() {
		String query = "SELECT p FROM Post p";
		return em.createQuery(query, Post.class).getResultList();
	}

	@Override
	public Post show(int id) {
		return em.find(Post.class, id);
	}

	@Override
	public Post create(Post p) {
		em.persist(p);
		em.flush();
		return p;
	}

	@Override
	public Post replace(int id, Post p) {
		Post managedPost = em.find(Post.class, id);
		
		managedPost.setTitle(p.getTitle());
		managedPost.setName(p.getName());
		managedPost.setEmail(p.getEmail());
		managedPost.setDescription(p.getDescription());
		managedPost.setPrice(p.getPrice());
		managedPost.setBrand(p.getBrand());
		
		return managedPost;
	}
	
	@Override
	public Post update(int id, Post p) {
		Post managedPost = em.find(Post.class, id);
		
		if(p.getTitle() != null && !p.getTitle().equals("")) {
			managedPost.setTitle(p.getTitle());
		}
		if(p.getName() != null && !p.getName().equals("")) {
			managedPost.setName(p.getName());
		}
		if(p.getEmail() != null && !p.getEmail().equals("")) {
			managedPost.setEmail(p.getEmail());
		}
		if(p.getDescription() != null && !p.getDescription().equals("")) {
			managedPost.setDescription(p.getDescription());
		}
		if(p.getPrice() != 0) {
			managedPost.setPrice(p.getPrice());
		}
		if(p.getBrand() != null && !p.getBrand().equals("")) {
			managedPost.setBrand(p.getBrand());
		}
		return null;
	}



	@Override
	public boolean destroy(int id) {
		try {
			Post p = em.find(Post.class, id);
			em.remove(p);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		return false;
	}

}
