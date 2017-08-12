package mum.ea.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mum.ea.domain.Building;
import mum.ea.service.BuildingService;

@RestController
public class BuildingController {
	
	@Autowired
	private BuildingService buildingService;
	
	@RequestMapping("/buildings")
	public List<Building> getBuildings() {
		return buildingService.getAllBuildings();
	}
	
	@RequestMapping("/buildings/{id}")
	public Building getBuilding(@PathVariable int id) {
		return buildingService.getBuilding(id);
	}
}
