package com.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.eventmanagement.entities.Venue;

public interface VenueRepository extends CrudRepository<Venue, Long> {


}
