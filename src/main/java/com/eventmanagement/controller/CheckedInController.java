package com.eventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eventmanagement.controller.exception.AlreadyCheckedInException;
import com.eventmanagement.entities.Participant;
import com.eventmanagement.repos.ParticipantRepository;

@RepositoryRestController("/events")
public class CheckedInController {

	@Autowired
	private ParticipantRepository participantRepository;

	@PostMapping("/checkedin/{id}")
	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler persistentEntityResourceAssembler){
		Participant participant = participantRepository.findById(id).get();
		if(participant!=null) {
			if(participant.getCheckedIn()) {
			throw new AlreadyCheckedInException("Checked in");
		}
			participant.setCheckedIn(true);
			participantRepository.save(participant);
		}

		return ResponseEntity.ok(persistentEntityResourceAssembler.toFullResource(participant));

	}

}
