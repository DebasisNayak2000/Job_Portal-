package com.project.jobportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.jobportal.entity.Users;
import com.project.jobportal.entity.UsersType;
import com.project.jobportal.services.UsersService;
import com.project.jobportal.services.UsersTypeService;

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private final UsersTypeService usersTypeService;
	private final UsersService usersService ;

	public UserController(UsersTypeService usersTypeService, UsersService usersService) {
	
		this.usersTypeService = usersTypeService;
		this.usersService = usersService;
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		List< UsersType> usersTypes = usersTypeService.getAll();
		model.addAttribute("getAllTypes", usersTypes);
		model.addAttribute("user", new Users());
		return "register";
		
	}
    
	@PostMapping("/register/new")
	public String userRegistration(@Valid Users user, Model model)
	{
		Optional<Users> optionalUser = usersService.getUserByEmail(user.getEmail());
		if(optionalUser.isPresent()) {
			model.addAttribute("error", "Email is already registerd with us");
			
			List< UsersType> usersTypes = usersTypeService.getAll();
			model.addAttribute("getAllTypes", usersTypes);
			model.addAttribute("user", new Users());
			return "register";
		}
		usersService.addNew(user);
		return "dashboard";
	}
	
}
