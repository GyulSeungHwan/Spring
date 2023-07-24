package com.yedam.app.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Name {

	private String firstName;

	private String middleName;
	
	@Column(nullable = false) // not null
	private String lastName;
}