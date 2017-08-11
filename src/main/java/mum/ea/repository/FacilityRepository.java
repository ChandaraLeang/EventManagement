package mum.ea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.ea.domain.Facility;

@Repository
public interface FacilityRepository extends CrudRepository<Facility, Integer> {

}
