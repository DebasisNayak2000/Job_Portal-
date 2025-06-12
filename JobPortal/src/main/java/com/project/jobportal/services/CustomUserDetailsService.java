package com.project.jobportal.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.jobportal.entity.Users;
import com.project.jobportal.repository.UsersRepository;
import com.project.jobportal.util.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	private final UsersRepository usersRepository ;
	public CustomUserDetailsService(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		      Users  user = usersRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("Could not found any user") );
		return new CustomUserDetails(user);
	
	}
	
	

}
