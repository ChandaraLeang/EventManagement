package mum.ea.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.domain.Event;
import mum.ea.repository.EventRepository;

@Service
@Transactional
public class EventService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EventRepository eventRepository;
	
	public List<Event> getAllEvents() {
		List<Event> events = new ArrayList<>();
		eventRepository.findAll().forEach(events::add);
		return events;
	}

	public Event getEvent(int eventId) {
		return eventRepository.findOne(eventId);
	}
}