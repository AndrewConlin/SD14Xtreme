package com.skilldistillery.xtreme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.xtreme.services.CommentService;

@RestController
@RequestMapping("api")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
}
