package com.cheery.abadatacollector.target;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Target {
	@Id
	@GeneratedValue
	private int targetId;
	
	@Size(min=10, message="Enter at least 10 characters.")
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private String outcome;
	private boolean active;
	
	//To map Target to Student
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Student student;
	
	public Target() {
		
	}

	public Target(int targetId, @Size(min = 10, message = "Enter at least 10 characters.") String description,
			LocalDate startDate, LocalDate endDate, String outcome, boolean active) {
		super();
		this.targetId = targetId;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.outcome = outcome;
		this.active = active;
	}
	
	public int getTargetId() {
		return targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Target [targetId=" + targetId + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", outcome=" + outcome + ", active=" + active + "]";
	}

	
}
