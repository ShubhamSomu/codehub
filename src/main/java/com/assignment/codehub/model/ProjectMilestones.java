package com.assignment.codehub.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name="project_milestones")
@Data
public class ProjectMilestones extends BaseEntity{
	private static final long serialVersionUID = 1L;

	@JsonProperty("project")
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER,targetEntity = Project.class)
	private Project project;
	
	@JsonProperty("name")
	private String name;
}
