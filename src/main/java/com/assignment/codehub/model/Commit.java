package com.assignment.codehub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class Commit extends BaseEntity{
	private static final long serialVersionUID = 1L;

	@JsonProperty(value ="sha_id")
	@Column(name="SHA_ID")
	private String shaId;
	
	@JsonProperty(value ="author_id")
	@OneToOne
	@JoinColumn(name="author_id")
	private User author;
	
	
	@JsonProperty(value ="commiter_id")
	@OneToOne
	@JoinColumn(name="commiter_id")
	private User committer;
	
	
	@JsonProperty(value ="project_id")
	@OneToOne
	@JoinColumn(name="project_id")
	private Project project;
}
