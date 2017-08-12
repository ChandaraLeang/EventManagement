package mum.ea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mum.ea.domain.Facility;
import mum.ea.service.FacilityService;

@Controller
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("fullPageMessage", "Greetings from Spring Boot!");
		return "fullPageMessage";
	}
	
	@GetMapping("/facilities")
	public List<Facility> getFacilities() {
		return facilityService.getAllFacilities();
	}
	
	@GetMapping("/facilities/{id}")
	public Facility getFacility(@PathVariable int id) {
		return facilityService.getFacility(id);
	}
}
