package mum.ea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import mum.ea.domain.Event;
import mum.ea.service.CategoryService;
import mum.ea.service.EventService;
import mum.ea.service.FacilityService;

@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FacilityService facilityService;
	
	@GetMapping("/events")
	public String getEvents(Model m) {
		m.addAttribute("events", eventService.getAllEvents());
		return "eventList";
	}

	@GetMapping("/events/{id}")
	public String getEvent(@PathVariable int id, Model m) {
		m.addAttribute("categories", categoryService.getAllCategories());
		m.addAttribute("facilities", facilityService.getAllFacilities());
		m.addAttribute("event", eventService.getEvent(id));
		return "eventDetail";
	}
	
	@GetMapping("/addEvent")
	public String addEventView(Model m) {
		m.addAttribute("categories", categoryService.getAllCategories());
		m.addAttribute("facilities", facilityService.getAllFacilities());
		m.addAttribute("event" , new Event());
		return "eventDetail";
	}

	@PostMapping("/events")
	public String addEvent(Event e) {
		eventService.addEvent(e);
		return "redirect:/events";
	}

	@PostMapping("/events/{id}")
	public String updateEvent(Event e) {
		eventService.updateEvent(e);
		return "redirect:/events";
	}
	
	@PostMapping("/events/delete/{id}")
	public String deleteEvent(Event e) {
		eventService.deleteEvent(e.getId());
		return "redirect:/events";
	}
	
	@ExceptionHandler(value = NoSuchResourceException.class)
    public ModelAndView handle(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.getModel().put("e", e);
        mv.setViewName("fullPageMessage");
        return mv;
    }
}