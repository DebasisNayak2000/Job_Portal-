package com.project.jobportal.entity;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="users")
public class Users {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(unique= true)
	private String email;
	@Column
	private boolean isActive;
	@Column
	@NotEmpty
	private String password;
	@Column
	@DateTimeFormat
	private Date registrationDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userTypeId", referencedColumnName="userTypeId")
	private UsersType userTypeId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegistartionDate() {
		return registrationDate;
	}
	public void setRegistartionDate(Date registartionDate) {
		this.registrationDate = registartionDate;
	}
	public UsersType getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(UsersType userTypeId) {
		this.userTypeId = userTypeId;
	}
	
	
	public Users(int userId, String email, boolean isActive, @NotEmpty String password, Date registartionDate,
			UsersType userTypeId) {
		super();
		this.userId = userId;
		this.email = email;
		this.isActive = isActive;
		this.password = password;
		this.registrationDate = registartionDate;
		this.userTypeId = userTypeId;
	}
	public Users() {
		
	}
	
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", email=" + email + ", isActive=" + isActive + ", password=" + password
				+ ", registartionDate=" + registrationDate + ", userTypeId=" + userTypeId + "]";
	}
	
}
