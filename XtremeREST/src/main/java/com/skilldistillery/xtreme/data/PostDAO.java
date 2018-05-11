package com.skilldistillery.xtreme.data;

import java.util.List;

import com.skilldistillery.xtreme.entities.Post;

public interface PostDAO {
	List<Post> index();
	Post show(int id);
	Post create(Post p);
	Post update(int id, Post p);
	Post replace(int id, Post p);
	boolean destroy(int id);
}
