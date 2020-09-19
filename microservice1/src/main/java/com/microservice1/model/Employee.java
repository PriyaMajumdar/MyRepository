package com.microservice1.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import lombok.Data;


@Data
@Entity
@Table(name="employeedata")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(nullable=true)
	private String name;
	@Column(unique=true , nullable = false)
	private String companyname;
	@Column
	private Long phoneno;
	@Column(nullable = false)
	private String emailid;
	
	@Column
	private int zipcode;
	@Column(nullable = false)
	private String country;
	@Column(nullable = false)
	private String state;
	@Column(nullable = false)
	private String addressLine1;
	@Column(nullable = false)
	private String addressLine2;
	@Column(nullable = false)
	private String password;
	@Column(nullable=false)
	private String confirmpassword;
	
	 
	

}
