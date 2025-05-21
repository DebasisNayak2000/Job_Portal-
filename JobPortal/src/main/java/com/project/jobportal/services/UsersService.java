package com.project.jobportal.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.jobportal.entity.JobSeekerProfile;
import com.project.jobportal.entity.RecruiterProfile;
import com.project.jobportal.entity.Users;
import com.project.jobportal.repository.JobSeekerProfileRepository;
import com.project.jobportal.repository.RecruiterProfileRepository;
import com.project.jobportal.repository.UsersRepository;



@Service
public class UsersService {
	
	UsersRepository userRepository;
	RecruiterProfileRepository recruiterProfileRepository;
	JobSeekerProfileRepository jobSeekerProfileRepository;

	public UsersService(UsersRepository userRepository , RecruiterProfileRepository recruiterProfileRepository,
	JobSeekerProfileRepository jobSeekerProfileRepository) {
		this.userRepository = userRepository;
		this.jobSeekerProfileRepository = jobSeekerProfileRepository;
		this.recruiterProfileRepository = recruiterProfileRepository;
	}
	
	public Users addNew(Users user) {
		user.setActive(true);
		user.setRegistartionDate(new Date(System.currentTimeMillis()));	
		int userTypeID =user.getUserTypeId().getUserTypeId();
		if (userTypeID==1) {
			recruiterProfileRepository.save(new RecruiterProfile(user));
		}
		else {
			jobSeekerProfileRepository.save(new JobSeekerProfile(user));
		}
		return userRepository.save(user);
	}
	public Optional<Users> getUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
		
	}
	

}
