package com.assignment.codehub.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Entity(name = "User")
@Table(name = "user")
@SQLDelete(sql = "update user set deleted=true where id=?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted=false")

@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PUBLIC)
@Getter
@ToString(onlyExplicitlyIncluded = true)

public class User extends BaseEntity {

	/**
	 * // add swagger
	 * 
	 */

	private static final long serialVersionUID = 1L;
	/*
	 * public User(
	 * 
	 * @NotNull(message = "full name is mandatory") @Size(min = 3, message =
	 * "name should be atleast 3 char long") String fullName, String company,
	 * LocalDateTime created_at, Integer type, Boolean fake, Boolean deleted, Double
	 * longitude, Double latitude, Integer countrycode, String state, String city) {
	 * super(); this.fullName = fullName; this.company = company; this.created_at =
	 * created_at; this.type = type; this.fake = fake; this.deleted = deleted;
	 * this.longitude = longitude; this.latitude = latitude; this.countrycode =
	 * countrycode; this.state = state; this.city = city; }
	 */

	@ToString.Include
	@JsonProperty("full_name")
	@NotNull(message = "full name is mandatory")
	@Size(min = 3, message = "name should be atleast 3 char long")
	private String fullName;

	@ToString.Include
	// @NotNull(message = "company cannot be null")
	@JsonProperty("company")
	String company;

	@ToString.Include
	@JsonProperty("created_at")
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:ss")
	@Column(nullable = false)
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
	// @ManyToMany
	String password;

	@JsonIgnore
	  @ManyToMany(fetch=FetchType.EAGER)
	  @JoinTable(
		        name="user_role",
		        joinColumns=
		            @JoinColumn(name="user_id", referencedColumnName="id"),
		        inverseJoinColumns=
		            @JoinColumn(name="role_id", referencedColumnName="id")
		    )
	@Cascade(CascadeType.ALL)
	  Set<Role> role;

	@PreRemove
	public void delete() {
		this.deleted = true;
	}

	public User(User user) {
		this.city = user.city;
		this.company = user.company;
		this.countrycode = user.countrycode;
		this.created_at = user.created_at;
		this.deleted = user.deleted;
		this.fake = user.fake;
		this.fullName = user.fullName;
		this.id = user.id;
		this.latitude = user.latitude;
		this.longitude = user.longitude;
		this.password = user.password;
		this.state = user.state;
		this.type = user.type;
		this.role = user.role;
	}
}
