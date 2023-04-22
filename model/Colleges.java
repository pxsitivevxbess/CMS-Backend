package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "colleges") // Name of Table in DB
public class Colleges {
//Id is Primary Key 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY ) 
private long id;//CollegeId will be auto incremented as record is inserted by using GeneratedValue annotation and IDENTITY
@Column(name = "name")
private String name;

@Column(name = "address")
private String address;

@Column(name = "rank")
private String rank;

public Colleges()
{
	
}
public Colleges(String name, String address, String rank) {
	super();
	this.name = name;
	this.address = address;
	this.rank = rank;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getRank() {
	return rank;
}
public void setRank(String rank) {
	this.rank = rank;
}




}
