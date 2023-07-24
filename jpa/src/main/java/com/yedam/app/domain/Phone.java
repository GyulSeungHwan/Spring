package com.yedam.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Phone {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String phondNumber;
	
	public Phone(String phondNumber) {
		super();
		this.phondNumber = phondNumber;
	}
	
//	@ManyToOne
//	@JoinColumn(name = "person_id")
//	private Person person;
}
