package com.assignment.codehub.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table
@Data
public class Follower extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@JsonProperty("follower")
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private User user;
}
