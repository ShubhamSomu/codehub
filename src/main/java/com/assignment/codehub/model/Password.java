package com.assignment.codehub.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Value;
import lombok.experimental.NonFinal;

@Value 
@NonFinal
@Entity
@Table(name="password")
/** @Value lombok does @FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE) , 
allArgs constructor and Getters**/
public class Password extends BaseEntity{
	private static final long serialVersionUID = 1L;
	String password;
	String guess;
	boolean isValid;
	String modifyReason;
}
