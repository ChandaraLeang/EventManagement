package mum.ea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.ea.domain.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer>{

}