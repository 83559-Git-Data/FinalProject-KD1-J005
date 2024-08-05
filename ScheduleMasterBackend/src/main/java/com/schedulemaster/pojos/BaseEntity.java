package com.schedulemaster.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
// The @MappedSuperclass annotation in Java Persistence API (JPA) is used to designate 
//a class whose mapping information is applied to the entities that inherit from it.
//This annotation is typically used when you have common fields and mappings that
//you want to share across multiple entities, without creating an entity of the superclass itself.

public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CreationTimestamp
	@Column(name = "created_on")
	private LocalDateTime createdDate;
	@UpdateTimestamp
	@Column(name = "updated_on")
	private LocalDateTime updatedDate;
}
