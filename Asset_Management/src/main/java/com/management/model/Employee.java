package com.management.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Employee {

	@Id
	private int id;
	private String fullName;
	private String designation;
	
	@JsonIgnoreProperties("asset")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<Assest> asset= new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Set<Assest> getAsset() {
		return asset;
	}

	public void setAsset(Set<Assest> asset) {
		this.asset = asset;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String fullName, String designation, Set<Assest> asset) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.designation = designation;
		this.asset = asset;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", designation=" + designation + ", asset=" + asset
				+ "]";
	}
	
	
	 
}
