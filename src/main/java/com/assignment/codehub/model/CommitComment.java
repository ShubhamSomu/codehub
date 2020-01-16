package com.assignment.codehub.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CommitComment extends BaseEntity{
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	private Commit commit;
	
	@OneToOne
	private User user;
	String body;
	
}
