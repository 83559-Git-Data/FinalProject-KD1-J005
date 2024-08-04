package com.schedulemaster.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity(name = "users")
public class User extends BaseEntity {
	@Column(name = "fist_name")
	public String firstName;
	@Column(name = "last_name")
	public String lastName;
	@Column(name = "username",length = 30,nullable = false ,unique = true)
	public String userName;
	@Column(name = "password",length = 18,nullable = false)
	public String password;
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	public Role role;
	@Column(name = "status")
	private boolean status=true;
}
