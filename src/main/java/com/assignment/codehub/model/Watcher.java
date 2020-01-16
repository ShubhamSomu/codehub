package com.assignment.codehub.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
/**
 * This table wont be exposed just use it at code logic
**/
public class Watcher {
	@EmbeddedId
	ProjectUser project_user;
	
	@JsonProperty("created_at")
	@CreatedDate
	private LocalDateTime createdAt;
	
	/*	@ManyToOne
	@JoinColumn(name="project_id")
	private Project getProject() {
		return 
	}*/
}

