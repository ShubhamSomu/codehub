package com.assignment.codehub.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="organization_member")
@Data
public class OrganizationMember extends BaseEntity{
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<User> users;
	
}
