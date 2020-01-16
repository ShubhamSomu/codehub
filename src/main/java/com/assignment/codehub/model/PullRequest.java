package com.assignment.codehub.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class PullRequest extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@JsonProperty("head_project_id")
	@OneToOne
	@JoinColumn(name="head_project_id")
	private Project headProjectId;
	
	@JsonProperty("base_project_id")
	@OneToOne
	@JoinColumn(name="base_project_id")
	private Project  baseProjectId;
	
	@JsonProperty("head_commit_id")
	@OneToOne
	@JoinColumn(name="head_commit_id")
	private Commit headCommitId;
	
	@JsonProperty("base_commit_id")
	@OneToOne
	@JoinColumn(name="base_commit_id")
	private Commit baseCommitId;
	
	@JsonProperty("intra_branch")
	private Boolean intraBranch;
	
	@OneToMany
	@JoinTable(name="pull_request_commit",
			joinColumns = {
					@JoinColumn(name="pull_request_id", referencedColumnName = "id")
					}, 
			inverseJoinColumns = {
					@JoinColumn(name="comment_id", referencedColumnName="id")
			}
	
			)
	
	private List<Commit> commits;
	/**
	 * Intra branch true means head and base are same
	 * if head = null means project was deleted 
	 */
}
