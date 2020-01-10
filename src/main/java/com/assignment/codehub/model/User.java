package com.assignment.codehub.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "User")
@Table(name = "user")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(onlyExplicitlyIncluded = true)
@SQLDelete(sql = "update user set deleted=true where id=?",check = ResultCheckStyle.COUNT)
@Where(clause = "deleted=false")
public class User extends BaseEntity{

	/**
	 * // add swagger

	 */ 
	private static final long serialVersionUID = 1L;
	@ToString.Include
	@JsonProperty("full_name")
	@NotNull(message = "full name is mandatory")
	@Size(min = 3, message="name should be atleast 3 char long")
	private String fullName;
	
	
	@ToString.Include
	//@NotNull(message = "company cannot be null")
	@JsonProperty("company")
	String company;
	
	@ToString.Include
	@JsonProperty("created_at")
	@Column(nullable=false)
	LocalDateTime created_at;
	
	@ToString.Include
	@JsonProperty("user_type")
	Integer type;
	
	@JsonProperty("is_fake")
	Boolean fake;
	
	@JsonIgnore
	Boolean deleted;
	
	@JsonProperty("longitude")
	Double longitude;
	
	@JsonProperty("latitude")
	Double latitude;
	
	@ToString.Include
	@JsonProperty("country_code")
	Integer countrycode;
	
	@ToString.Include
	@JsonProperty("state")
	String state;
	
	@ToString.Include
	@JsonProperty("city")
	String city;
	
	@JsonIgnore
	String password;
}
