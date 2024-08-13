package com.schedulemaster.pojos;
import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Getter
//@Setter
////@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity(name = "courses")
//public class Course extends BaseEntity {
//	@Column(name = "name", nullable = false, length = 50)
//	private String courseName;
//	@Column(name = "fees", nullable = false, precision = 4)
//	private double fees;
//	@Column(name = "descrption")
//	private String description;
//	@Column(name = "start_date")
//	private LocalDate startDate;
//	@Column(name = "end_date")
//	private LocalDate endDate;
//	@Column(name = "capacity")
//	private int Capacity;
//	@ManyToMany
//	@JoinTable(name = "course_modules",joinColumns = @JoinColumn(name="course_id"),
//	inverseJoinColumns = @JoinColumn(name="module_id"))
//	private Set<Module> modules=new HashSet<>();
//	
//	public void addModule(Module module) {
//		this.modules.add(module);
//		module.getCourses().add(this);	
//	}
//	
//	public void removeModule(Module module) {
//		this.modules.remove(module);
//		module.getCourses().remove(this);
//	}
//}
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Entity(name = "courses")
public class Course extends BaseEntity {
    @Column(name = "name", nullable = false, length = 50)
    private String courseName;
    
    @Column(name = "fees", nullable = false, precision = 4)
    private double fees;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "start_date")
    private LocalDate startDate;
    
    @Column(name = "end_date")
    private LocalDate endDate;
    
    @Column(name = "capacity")
    private int capacity;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)//(fetch = FetchType.EAGER)
    @JoinTable(name = "course_modules", joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id"))
//    @JsonManagedReference
//    @JsonIgnore
    @JsonManagedReference
    private Set<Module> modules = new HashSet<>();

    // Getters and Setters

    public void addModule(Module module) {
        this.modules.add(module);
//        module.getCourses().add(this);
    }

    public void removeModule(Module module) {
        this.modules.remove(module);
//        module.getCourses().remove(this);
    }
}
