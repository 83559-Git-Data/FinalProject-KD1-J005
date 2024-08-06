package com.schedulemaster.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "modules")
public class Module extends BaseEntity {
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	@Column(name = "hours", nullable = false)
	private int hours;	

	@ManyToMany(mappedBy = "modules")
	private List<Course> courses=new ArrayList<Course>();

	@ManyToMany(mappedBy = "modules")
	private List<Faculty> faculties=new ArrayList<Faculty>();

	public void addCourse(Course course) {
		this.courses.add(course);
		course.getModules().add(this);
	}
	
	public void removeCourse(Course course) {
		this.courses.remove(course);
		course.removeModule(this);
	} 
	
	public void addFaculty(Faculty faculty) {
		this.faculties.add(faculty);
		faculty.getModules().add(this);
	}
	
	public void removeFaculty(Faculty faculty) {
		this.faculties.remove(faculty);
		faculty.removeModule(this);
	}
}
