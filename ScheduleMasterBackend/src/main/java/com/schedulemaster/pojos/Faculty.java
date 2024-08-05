package com.schedulemaster.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
	@Column(name = "mobile_no",nullable = true)
	private String mobNo;
	@OneToOne
	@JoinColumn(name = "userId")
	private User userId;
	@Column(name = "address")
	private String address;
	@Column(name = "current_age")
	private int currentAge;
}
