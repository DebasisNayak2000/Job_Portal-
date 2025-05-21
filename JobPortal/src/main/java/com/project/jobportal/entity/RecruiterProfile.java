package com.project.jobportal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="recruiter_profile")
public class RecruiterProfile {
	@Id
	private int userAccountId;	
	@OneToOne
	@JoinColumn(name="user_account_id")
	@MapsId
	private Users userId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column(nullable= true, length=64)
	private String profilePhoto;
	@Column
	private String city;
	@Column
	private String company;
	@Column
	private String country;
	@Column
	private String state;
	@Override
	public String toString() {
		return "RecruiterProfile [userAccountId=" + userAccountId + ", userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", profilephoto=" + profilePhoto + ", city=" + city + ", company="
				+ company + ", country=" + country + ", state=" + state + "]";
	}
	public RecruiterProfile(Users user) {
		 this.userId = user;
	}
	public RecruiterProfile(int userAccountId, Users userId, String firstName, String lastName, String profilephoto,
			String city, String company, String country, String state) {
		super();
		this.userAccountId = userAccountId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profilePhoto = profilephoto;
		this.city = city;
		this.company = company;
		this.country = country;
		this.state = state;
	}
	public int getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(int userAccountId) {
		this.userAccountId = userAccountId;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
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
	public String getProfilephoto() {
		return profilePhoto;
	}
	public void setProfilephoto(String profilephoto) {
		this.profilePhoto = profilephoto;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
