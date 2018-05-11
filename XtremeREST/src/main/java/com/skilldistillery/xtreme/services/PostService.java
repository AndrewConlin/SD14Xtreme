package com.skilldistillery.xtreme.services;

import java.util.List;

import com.skilldistillery.xtreme.entities.Comment;
import com.skilldistillery.xtreme.entities.Post;

public interface PostService {
	public List<Comment> getCommentsForPostById(int id);
	public Comment createComment(int id, Comment comment);
	public boolean deleteComment(int postId, int commentId);
	public List<Post> searchForPosts(String keyword);
	public List<Post> searchPostsByPrice(int low, int high);
}
