package com.eventmanagement.entities;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
@JsonPropertyOrder({"resourceId"})
public class Event extends AbstractEntity {
	private String name;
	@JsonProperty("desc")
	private String description;
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
	private ZoneId zoneId;
	private Boolean started;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Organizer organizer;
	@OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Participant> participants;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@RestResource(exported = false)
	private Venue venue;
	public Long getResourceId() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Event) obj).id);
	}
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
