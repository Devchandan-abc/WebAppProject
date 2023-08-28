package com.example.WebAppProject.config.auth;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.WebAppProject.entity.Registration;
import com.example.WebAppProject.exception.FileNotFoundException;
import com.example.WebAppProject.repository.RegistrationRepository;
//import com.example.WebAppProject.repository.UserRepository;
@Component
public class CustomUserDetailsService implements  UserDetailsService {
	@Autowired	
	//private UserRepository repository;
	private RegistrationRepository registrationrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//fetching the user object from db 
		//same user object we are giving to userobject provided by spring security to validate if username and password is valid or not
		// TODO Auto-generated method stub
		//  User user = repository.findByUserName(username);
		Optional<Registration> user = registrationrepo.findByUserName(username);
	        return new org.springframework.security.core.userdetails.User(user.get().getUserName(), user.get().getPassword(), new ArrayList<>());
	}

}
