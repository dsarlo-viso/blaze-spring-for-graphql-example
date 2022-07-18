package com.blaze.spring.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table (name = "user_table")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private ZonedDateTime createdDate;

	private ZonedDateTime updatedDate;

	@PrePersist
	public void prePersist() {
		this.createdDate = ZonedDateTime.now();
		this.updatedDate = this.createdDate;
	}

	@PreUpdate
	public void preUpdate() {
		this.updatedDate = ZonedDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ZonedDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(ZonedDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public ZonedDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(ZonedDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
}
