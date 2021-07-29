package com.management.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity

@Table(name = "emp_Asset")
public class Assest {

	@Id
	private int assetId;
	private String assetName;
	private LocalDate purchaseDate;
	private String conditionNote;
	private String category;
	private String assignedStatus;
	
	@JsonIgnoreProperties("employee")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id")
	private Employee employee;

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getConditionNote() {
		return conditionNote;
	}

	public void setConditionNote(String conditionNote) {
		this.conditionNote = conditionNote;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAssignedStatus() {
		return assignedStatus;
	}

	public void setAssignedStatus(String assignedStatus) {
		this.assignedStatus = assignedStatus;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Assest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Assest(int assetId, String assetName, LocalDate purchaseDate, String conditionNote, String category,
			String assignedStatus, Employee employee) {
		super();
		this.assetId = assetId;
		this.assetName = assetName;
		this.purchaseDate = purchaseDate;
		this.conditionNote = conditionNote;
		this.category = category;
		this.assignedStatus = assignedStatus;
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Assest [assetId=" + assetId + ", assetName=" + assetName + ", purchaseDate=" + purchaseDate
				+ ", conditionNote=" + conditionNote + ", category=" + category + ", assignedStatus=" + assignedStatus
				+ ", employee=" + employee + "]";
	}
	
	
	 
	    
}
