package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Authors")
public class Author {
	
	@Id
	@Column(name = "phonenumber")
	private int phonenumber;
	private String firstName;
	private String lastname;
	private String city;

	

}
