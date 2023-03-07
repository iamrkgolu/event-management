package com.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.eventmanagement.entities.Organizer;

public interface OrganizerRepository extends CrudRepository<Organizer, Long> {

}
