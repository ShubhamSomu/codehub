package com.assignment.codehub.exception;

import org.joda.time.LocalDateTime;

import com.assignment.codehub.utility.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
public class ExceptionResponse {
	private String message;
	@JsonSerialize(using = CustomDateSerializer.class)

	private LocalDateTime date;
	private String description;
}
