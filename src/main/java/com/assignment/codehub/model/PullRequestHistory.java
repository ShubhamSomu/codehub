package com.assignment.codehub.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class PullRequestHistory extends BaseEntity{

	private static final long serialVersionUID = 1L;
	@JsonProperty(value="pull_requests")
	@OneToMany()
	@JoinColumn(name="pull_request_history")
	List<PullRequest> pullRequestHistory;
	
	@JsonProperty("action")
	String action;
	
	@JsonProperty(value="user_id")
	@OneToOne
	@JoinColumn(name="actor")
	private User user;
}
