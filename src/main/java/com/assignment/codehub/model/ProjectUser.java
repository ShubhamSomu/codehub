package com.assignment.codehub.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
final class ProjectUser implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name="project_id")
	private Long projectId;
	
	@Column(name="user_id")
	private Long userId;
	

}