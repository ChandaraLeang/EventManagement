package mum.ea.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mum.ea.domain.Facility;
import mum.ea.domain.FacilityType;
import mum.ea.service.EventService;
import mum.ea.service.FacilityService;

@Controller
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/")
	public String index(Model model) {
		/*model.addAttribute("fullPageMessage", "Greetings from Spring Boot!");
		return "fullPageMessage";*/
		model.addAttribute("events", eventService.getAllEvents());
		return "upcomingEventList";
	}
	
	@GetMapping("/facilities")
	public String getFacilitys(Model m) {
		m.addAttribute("facilities", facilityService.getAllFacilities());
		return "facilityList";
	}

	@GetMapping("/facilities/{id}")
	public String getFacility(@PathVariable int id, Model m) {
		List<FacilityType> types = new ArrayList<FacilityType>(Arrays.asList(FacilityType.values()));
		m.addAttribute("facilityTypes", types);
		m.addAttribute("facility", facilityService.getFacility(id));
		return "facilityDetail";
	}
	
	@GetMapping("/addFacility")
	public String addFacilityView(Model m) {
		m.addAttribute("facility" , new Facility());
		return "facilityDetail";
	}

	@PostMapping("/facilities")
	public String addFacility(Facility b) {
		facilityService.addFacility(b);
		return "redirect:/facilities";
	}

	@PostMapping("/facilities/{id}")
	public String updateFacility(Facility b) {
		facilityService.updateFacility(b);
		return "redirect:/facilities";
	}
	
	@PostMapping("/facilities/delete/{id}")
	public String deleteFacility(Facility b) {
		facilityService.deleteFacility(b.getId());
		return "redirect:/facilities";
	}
}
