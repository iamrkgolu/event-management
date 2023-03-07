package com.eventmanagement.entities;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class AbstractEntity {
	@Id
	@Column(nullable = false,updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@CreationTimestamp
	@Column(updatable = false)
	@JsonIgnore
	protected Instant created;
}
