package com.assignment.codehub.model;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IssueEvent extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value="issue")
	@OneToOne
	private Issue issueId;
	
	@JsonProperty(value="user")
	@OneToOne
	private User user;
	
	@JsonProperty(value="action")
	private String action;
	
	@JsonProperty(value="specific_action")
	private String specificAction; // id of last commit
}
