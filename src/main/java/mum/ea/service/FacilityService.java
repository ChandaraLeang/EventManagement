package mum.ea.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.domain.Facility;
import mum.ea.repository.FacilityRepository;

@Service
@Transactional
public class FacilityService {
	
	@PersistenceContext	
	private EntityManager entityManager;	

	@Autowired
	private FacilityRepository facilityRepository;

	public List<Facility> getAllFacilities() {
		List<Facility> facilities = new ArrayList<>();
		facilityRepository.findAll().forEach(facilities::add);
		return facilities;
	}

	public Facility getFacility(int facilityId) {
		return facilityRepository.findOne(facilityId);
	}
}
