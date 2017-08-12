package mum.ea.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.domain.Building;
import mum.ea.repository.BuildingRepository;

@Service
@Transactional
public class BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;

	public List<Building> getAllBuildings() {
		List<Building> buildings = new ArrayList<>();
		buildingRepository.findAll().forEach(buildings::add);
		return buildings;
	}

	public Building getBuilding(int buildingId) {
		return buildingRepository.findOne(buildingId);
	}

	public void addBuilding(Building building) {
		buildingRepository.save(building);
	}

	public void updateBuilding(Building building) {
		buildingRepository.save(building);
	}

	public void deleteBuilding(Building building) {
		buildingRepository.delete(building);
	}
	
	public void deleteBuilding(int buildingId) {
		buildingRepository.delete(buildingId);
	}
}
