package com.skilldistillery.xtreme.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.xtreme.data.PostDAO;
import com.skilldistillery.xtreme.entities.Comment;
import com.skilldistillery.xtreme.entities.Post;
import com.skilldistillery.xtreme.services.PostService;

@RestController
@RequestMapping("api")
public class PostController {

	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private PostService postService;

	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(202);
		response.setHeader("Location", "http://localhost:8080/api/ping");
		return "pong";
	}

	@RequestMapping(path = "posts", method = RequestMethod.GET)
	public List<Post> index() {
		return postDAO.index();
	}

	@RequestMapping(path = "posts/{id}", method = RequestMethod.GET)
	public Post show(@PathVariable int id) {
		return postDAO.show(id);
	}

	@RequestMapping(path = "posts", method = RequestMethod.POST)
	public Post create(@RequestBody Post p, HttpServletResponse res) {
		p = postDAO.create(p);
		if(p == null) {
			res.setStatus(500);
			return null;
		}
		
		res.setStatus(201);
		return p;
	}

	@RequestMapping(path = "posts/{id}", method = RequestMethod.PUT)
	public Post replace(@RequestBody Post p, @PathVariable int id) {
		return postDAO.replace(id, p);
	}

	@RequestMapping(path = "posts/{id}", method = RequestMethod.PATCH)
	public Post update(@RequestBody Post p, @PathVariable int id) {
		return postDAO.update(id, p);
	}

	@RequestMapping(path = "posts/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		postDAO.destroy(id);
	}
		
	@RequestMapping(path="posts/{id}/comments", method=RequestMethod.GET)
	public List<Comment> indexForComments(@PathVariable int id){
		return postService.getCommentsForPostById(id);
	}
	
	@RequestMapping(path="posts/{id}/comments", method=RequestMethod.POST)
	public Comment createComment(@PathVariable int id, @RequestBody Comment comment){
		return postService.createComment(id, comment);
	}
	
	@RequestMapping(path="posts/{id}/comments/{cid}", method=RequestMethod.DELETE)
	public boolean deleteComment(@PathVariable int id, @PathVariable int cid){
		return postService.deleteComment(id, cid);
	}
	
	@RequestMapping(path="posts/search/{keyword}", method=RequestMethod.GET)
	public List<Post> searchByKeyword(@PathVariable String keyword){
		return postService.searchForPosts(keyword);
	}
	
	@RequestMapping(path="posts/search/price/{low}/{high}", method=RequestMethod.GET)
	public List<Post> searchByKeyword(@PathVariable int low, @PathVariable int high){
		return postService.searchPostsByPrice(low, high);
	}

}
