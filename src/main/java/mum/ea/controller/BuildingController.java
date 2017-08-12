package mum.ea.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mum.ea.domain.Building;
import mum.ea.domain.BuildingType;
import mum.ea.service.BuildingService;

@Controller
public class BuildingController {

	@Autowired
	private BuildingService buildingService;

	@GetMapping("/buildings")
	public String getBuildings(Model m) {
		m.addAttribute("buildings", buildingService.getAllBuildings());
		return "buildingList";
	}

	@GetMapping("/buildings/{id}")
	public String getBuilding(@PathVariable int id, Model m) {
		List<BuildingType> types = new ArrayList<BuildingType>(Arrays.asList(BuildingType.values()));

		m.addAttribute("buildingTypes", types);
		m.addAttribute("building", buildingService.getBuilding(id));
		return "buildingDetail";
	}
	
	@GetMapping("/addBuilding")
	public String addBuildingView(Model m) {
		m.addAttribute("building" , new Building());
		return "buildingDetail";
	}

	@PostMapping("/buildings")
	public String addBuilding(Building b) {
		buildingService.addBuilding(b);
		return "redirect:/buildings";
	}

	@PostMapping("/buildings/{id}")
	public String updateBuilding(Building b) {
		buildingService.updateBuilding(b);
		return "redirect:/buildings";
	}
	@DeleteMapping("/buildings/{id}")
	public String deleteBuilding(@PathVariable int id) {
		buildingService.deleteBuilding(id);
		return "redirect:/buildings";
	}

}
