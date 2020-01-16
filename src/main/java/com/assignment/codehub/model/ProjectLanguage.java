package com.assignment.codehub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table
@Data
public class ProjectLanguage extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@JsonProperty("language")
	private String language;
	@ManyToOne
	private Project project;
	
	@JsonProperty("bytes")
	@Column(name="bytes_percent")
	private Integer bytes;
}
