package main.java.com.taskTracker.model;

import java.time.LocalDateTime;

public class Task {
	private int id;
	private String description;
	private boolean status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public Task(int id, String description, boolean status) {
		this.id = id;
		this.description = description;
		this.status = status;
	}
	
	// Setters y getters
	public int getId() {
		return this.id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean getStatus() {
		return this.status;
	}
	public void setStatus(boolean status) { 
		this.status = status;
	}
	public LocalDateTime createdAt() {
		return this.createdAt;
	}
	public LocalDateTime updatedAt() {
		return this.updatedAt;
	}
	
	// Methods
	public String formatToCsv() {
		return id + "," + description + "," + (status ? "1" : "0");
	}
}
