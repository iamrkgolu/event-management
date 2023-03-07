package com.eventmanagement.entities;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Organizer extends AbstractEntity {
	private String name;
	@OneToMany(mappedBy = "organizer")
	private Set<Event> events;

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Organizer) obj).id);
	}
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}
