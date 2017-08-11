package mum.ea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mum.ea.domain.Event;
import mum.ea.service.EventService;

@RestController
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping("/events")
	public List<Event> getEvents() {
		return eventService.getAllEvents();
	}
	
	@RequestMapping("/events/{id}")
	public Event getEvent(@PathVariable int id) {
		return eventService.getEvent(id);
	}
}