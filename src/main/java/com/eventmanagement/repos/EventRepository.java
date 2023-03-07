package com.eventmanagement.repos;

import com.eventmanagement.entities.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eventmanagement.entities.Event;
import com.eventmanagement.entities.projections.PartialEventsProjection;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource(excerptProjection = PartialEventsProjection.class)
public interface EventRepository extends CrudRepository<Event, Long>{
	Page<Event> findByName(@Param(value = "name") String name, Pageable pageable);
//	@PreAuthorize("hasRole(ROLE_ADMIN)")
//	default void delete(Long id) {

	}


