package com.skilldistillery.xtreme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.xtreme.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentRepository commentRepo;
}
