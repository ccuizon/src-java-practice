package com.cheery.abadatacollector.target;

import java.time.LocalDate;

public class Target {
	private int id;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private String outcome;
	private boolean active;
	
	public Target() {
		
	}
	
	



	public Target(int id, String description, LocalDate startDate, LocalDate endDate, String outcome, boolean active) {
		super();
		this.id = id;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.outcome = outcome;
		this.active = active;
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Target [id=" + id + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", outcome=" + outcome + ", active=" + active + "]";
	}
	
}
