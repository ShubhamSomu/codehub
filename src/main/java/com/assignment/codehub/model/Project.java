package com.assignment.codehub.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "repository")
@Data
@SQLDelete(sql = "update deleted=true Where id=?", check = ResultCheckStyle.COUNT)
@Where(clause="deleted=false")
public class Project extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@NotNull
	@Column(unique=true,nullable=false)
	@JsonProperty("clone_url")
	private String cloneUrl;
/** 
 * will contain clone url with header of git removed . will be unique for a repo
* either ssh or https for https, domain part is changed same for ssh
*/
	
	@NotNull
	@Column(nullable=false)
	@JsonProperty("repo_name")
	private String name; // this "repo name" is unique per user. 
	/** at time of repo creation unique name is checked, cant have duplicate name repo **/
	
	@JsonProperty("repo_desc")
	private String description;
	
	@JsonProperty("repo_lang")
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "project")
	private List<ProjectLanguage> languages;
	
	@JsonProperty("forked_from")
	@OneToOne
	private Project forkedFrom;
	/**
		When forking new project is created with forkedFrom as parent proj id
	**/
	
	@JsonIgnore
	private Boolean deleted;
	
	@JsonProperty("updated_at")
	@LastModifiedDate
	private Integer updated_at;
	
	@JsonIgnore
	@ToString.Exclude
	@ManyToMany(mappedBy="projects")
	List<User> users;
	
	@PreRemove
	private void delete() {
		this.deleted=true;
	}
}
