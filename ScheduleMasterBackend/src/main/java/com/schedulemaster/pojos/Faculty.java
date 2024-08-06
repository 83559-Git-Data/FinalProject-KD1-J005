package com.schedulemaster.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "faculty")
public class Faculty extends BaseEntity {
	@Column(name = "pan_no", nullable = false, unique = true, length = 30)
	private String panId;
	@Column(name = "dob", nullable = false)
	private LocalDate dob;
	@Column(name = "mobile_no", nullable = true)
	private String mobNo;
	@OneToOne
	@JoinColumn(name = "userId")
	private User userId;
	@Column(name = "address")
	private String address;
	@Column(name = "current_age")
	private int currentAge;
	@ManyToMany
	@JoinTable(name = "faculty_module", joinColumns = @JoinColumn(name = "faculty_id"), inverseJoinColumns = @JoinColumn(name = "module_id"))
	private Set<Module> modules=new HashSet<>();
	
	public void addModule(Module module) {
		this.modules.add(module);
		module.getFaculties().add(this);
		}
	public void removeModule(Module module) {
		this.modules.remove(module);
		module.getFaculties().remove(this);	
	}
}
