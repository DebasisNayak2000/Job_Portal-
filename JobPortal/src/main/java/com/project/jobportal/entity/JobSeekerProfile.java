package com.project.jobportal.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="job_seeker_profile")
public class JobSeekerProfile {	
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
	private String country;
	@Column
	private String state;
	@Column
	private String resume;
	@Column
	private String workAuthorization;
	@Column
	private String employmentType;
	@OneToMany(targetEntity = Skills.class, cascade = CascadeType.ALL, mappedBy="jobSeekerProfile")
	private List<Skills> skills;
	public JobSeekerProfile(int userAccountId, Users userId, String firstName, String lastName, String profilePhoto,
			String city, String country, String state, String resume, String workAuthorization, String employmentType,
			List<Skills> skills) {
		super();
		this.userAccountId = userAccountId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profilePhoto = profilePhoto;
		this.city = city;
		this.country = country;
		this.state = state;
		this.resume = resume;
		this.workAuthorization = workAuthorization;
		this.employmentType = employmentType;
		this.skills = skills;
	}

	public JobSeekerProfile(Users user) {
		 this.userId = user;
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

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getWorkAuthorization() {
		return workAuthorization;
	}

	public void setWorkAuthorization(String workAuthorization) {
		this.workAuthorization = workAuthorization;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "JobSeekerProfile [userAccountId=" + userAccountId + ", userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", profilephoto=" + profilePhoto + ", city=" + city + ", country="
				+ country + ", state=" + state + ", resume=" + resume + ", workAuthorization=" + workAuthorization
				+ ", employementType=" + employmentType + ", skills=" + skills + "]";
	}
}
