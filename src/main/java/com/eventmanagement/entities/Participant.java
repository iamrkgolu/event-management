package com.eventmanagement.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Participant extends AbstractEntity {
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	private Boolean checkedIn;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "ID",nullable = false,updatable = false)
	private Event event;

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Participant) obj).id);
	}
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}
