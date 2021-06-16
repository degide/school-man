package com.egide.schoolman.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private int number;
	
	private String description;
	
	@OneToMany
    private Set<CourseAssignment> courseAssignments = new HashSet<>();
	
	public Course() {}
	
	public Course(String name, int number, String description) {
		this.name = name;
		this.number = number;
		this.description = description;
	}
	
	public Course(Long id, String name, int number, String description) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.description = description;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
