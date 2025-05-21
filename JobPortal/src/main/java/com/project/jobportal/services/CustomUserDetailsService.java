package com.project.jobportal.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.jobportal.repository.UsersRepository;

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
		
		usersRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("Could not found any user") );
		return null;
	
	}
	

}
