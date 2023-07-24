package com.yedam.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "Contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private Name name;
	
	@Column(length = 2000) // 255 char -> 2000 char
	private String notes;

	private boolean starred;

}