package com.assignment.codehub.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Entity
@Data
public class Issue extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "project")
	@ManyToOne
	private Project project;

	@JsonProperty(value = "reported_by")
	@OneToOne
	private User reporterId;

	@JsonProperty(value = "assigned_to")
	private User assigneeId;

	@JsonProperty(value = "issue_id")
	private Long issueId;

	@JsonProperty("pull_request_id")
	@OneToOne
	private PullRequest pullRequest;

	@JsonProperty(value = "users")
	@OneToMany
	private List<User> users; // users that have commented on this issue

	@JsonProperty(value = "comment")
	String comment;
}
