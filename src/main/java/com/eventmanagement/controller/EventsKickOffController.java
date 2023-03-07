package com.eventmanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eventmanagement.entities.Event;
import com.eventmanagement.repos.EventRepository;

@RepositoryRestController("events")
public class EventsKickOffController {

	@Autowired
	private EventRepository eventRepository;

	@PostMapping("/start/{id}")
	public ResponseEntity strat(@PathVariable Long id){
		Optional<Event> findById = eventRepository.findById(id);
		if(!findById.isPresent()) {
			throw new ResourceNotFoundException("Data not available");
		}
		findById.get().setStarted(true);
		eventRepository.save(findById.get());
		return ResponseEntity.ok(findById.get().getName() +" started");
	}

}
