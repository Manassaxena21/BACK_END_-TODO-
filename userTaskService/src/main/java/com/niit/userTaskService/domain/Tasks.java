package com.niit.userTaskService.domain;

import java.io.Serializable;
import java.util.Date;


//import java.sql.Date;

import org.springframework.data.annotation.Id;


public class Tasks implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int taskCode;
	private String taskTitle;
	private Date taskDate;
	private String categoryName;
	private String taskDescription;
	private String imagelink;
	private boolean active = true;
	
	
	public Tasks(){}


	public Tasks(int taskCode, String taskTitle, Date taskDate, String categoryName, String taskDescription, String imagelink, boolean active) {
		this.taskCode = taskCode;
		this.taskTitle = taskTitle;
		this.taskDate = taskDate;
		this.categoryName = categoryName;
		this.taskDescription = taskDescription;
		this.imagelink = imagelink;
		this.active = active;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(int taskCode) {
		this.taskCode = taskCode;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public Date getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getImagelink() {
		return imagelink;
	}

	public void setImagelink(String imagelink) {
		this.imagelink = imagelink;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Tasks{" +
				"taskCode=" + taskCode +
				", taskTitle='" + taskTitle + '\'' +
				", taskDate=" + taskDate +
				", categoryName='" + categoryName + '\'' +
				", taskDescription='" + taskDescription + '\'' +
				", imagelink='" + imagelink + '\'' +
				", active=" + active +
				'}';
	}
}
