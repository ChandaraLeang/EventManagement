package mum.ea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mum.ea.domain.EventGroup;
import mum.ea.service.EventGroupService;

@RestController
public class EventGroupController {
	
	@Autowired
	private EventGroupService groupService;
	
	@RequestMapping("/groups")
	public List<EventGroup> getGroups() {
		return groupService.getAllGroups();
	}
	
	@RequestMapping("/groups/{id}")
	public EventGroup getEvent(@PathVariable int id) {
		return groupService.getGroup(id);
	}
}