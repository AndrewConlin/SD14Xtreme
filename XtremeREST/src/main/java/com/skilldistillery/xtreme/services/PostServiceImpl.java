package com.skilldistillery.xtreme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.xtreme.entities.Comment;
import com.skilldistillery.xtreme.entities.Post;
import com.skilldistillery.xtreme.repositories.CommentRepository;
import com.skilldistillery.xtreme.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private CommentRepository commentRepo;

	@Override
	public List<Comment> getCommentsForPostById(int id) {
		return commentRepo.findByPostId(id);
	}

	@Override
	public Comment createComment(int id, Comment comment) {
		Post post = postRepo.findById(id).get();
		comment.setPost(post);
		return commentRepo.saveAndFlush(comment);
	}

	@Override
	public boolean deleteComment(int postId, int commentId) {
		Comment comment = commentRepo.findById(commentId).get();
		
		if(comment.getPost().getId() == postId) {
			commentRepo.deleteById(commentId);
			return true;
		}
		
		return false;
	}

	@Override
	public List<Post> searchForPosts(String keyword) {
		return postRepo.findByTitleContainingOrNameContaining(keyword, keyword);
	}

	@Override
	public List<Post> searchPostsByPrice(int low, int high) {
		return postRepo.findByPriceBetween(low, high);
	}
}
