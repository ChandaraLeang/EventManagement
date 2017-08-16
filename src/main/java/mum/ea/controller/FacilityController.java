package mum.ea.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mum.ea.domain.Facility;
import mum.ea.domain.FacilityType;
import mum.ea.service.BuildingService;
import mum.ea.service.FacilityService;

@Controller
@RequestMapping(value = "/admin")
public class FacilityController {

	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private BuildingService buildingService;

	/*@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("fullPageMessage", "Greetings from Spring Boot!");
		return "fullPageMessage";
	}*/

	@GetMapping("/facilities")
	public String getFacilitys(Model m) {
		m.addAttribute("facilities", facilityService.getAllFacilities());
		return "facilityList";
	}
	
	@GetMapping("/buildings/{buildingId}/facilities")
	public String getBuildingFacilities(@PathVariable int buildingId, Model m) {
		m.addAttribute("facilities", facilityService.findByBuilding(buildingId));
		return "facilityList";
	}

	@GetMapping("/facilities/{id}")
	public String getFacility(@PathVariable int id, Model m) {
		List<FacilityType> types = new ArrayList<FacilityType>(Arrays.asList(FacilityType.values()));
		m.addAttribute("facilityTypes", types);
		m.addAttribute("buildings", buildingService.getAllBuildings());
		m.addAttribute("facility", facilityService.getFacility(id));
		return "facilityDetail";
	}

	@GetMapping("/addFacility")
	public String addFacilityView(Model m) {
		m.addAttribute("buildings", buildingService.getAllBuildings());
		m.addAttribute("facility", new Facility());
		return "facilityDetail";
	}

	@PostMapping("/facilities")
	public String addFacility(@Valid Facility b, BindingResult result) {
		if (result.hasErrors() || facilityService.existFacilityCode(b)) {
			return "facilityDetail";
		}

		else {
			facilityService.addFacility(b);
			return "redirect:/admin/facilities";
		}
	}

	@PostMapping("/facilities/{id}")
	public String updateFacility(@Valid Facility b, BindingResult result) {
		if (result.hasErrors()) {
			return "facilityDetail";
		} else {
			facilityService.updateFacility(b);
			return "redirect:/admin/facilities";
		}
	}

	@PostMapping("/facilities/delete/{id}")
	public String deleteFacility(Facility b) {
		facilityService.deleteFacility(b.getId());
		return "redirect:/admin/facilities";
	}
}
