package com.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.eventmanagement.entities.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {

}
