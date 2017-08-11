package mum.ea.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mum.ea.domain.Facility;
import mum.ea.service.FacilityService;

@RestController
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;
	
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@RequestMapping("/facilities")
	public List<Facility> getFacilities() {
		return facilityService.getAllFacilities();
	}
	
	@RequestMapping("/facilities/{id}")
	public Facility getFacility(@PathVariable int id) {
		return facilityService.getFacility(id);
	}
}
