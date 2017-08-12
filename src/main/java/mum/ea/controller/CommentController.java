package mum.ea.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mum.ea.domain.Comment;
import mum.ea.domain.Event;
import mum.ea.service.CommentService;
import mum.ea.service.EventService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/comments")
	public List<Comment> getComments() {
		return commentService.getAllComments();
	}
	
	@RequestMapping("/comments/{id}")
	public Comment getComment(@PathVariable int id) {
		return commentService.getComment(id);
	}

}
