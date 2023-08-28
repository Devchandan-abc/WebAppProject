package com.example.WebAppProject.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.example.WebAppProject.config.auth.AuthRequest;
import com.example.WebAppProject.config.auth.JwtUtil;
import com.example.WebAppProject.entity.ImageDetails;
import com.example.WebAppProject.entity.Registration;
import com.example.WebAppProject.service.ServiceInterface;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class RegistrationController {
	@Autowired
	private ServiceInterface serviceInterface;
	

	@PostMapping("/save")
	public ResponseEntity<Registration> saveUser(@RequestBody Registration registration)
	{
		return new ResponseEntity<>(serviceInterface.saveUser(registration),HttpStatus.CREATED);
	}
	@PostMapping("/login")
	public ResponseEntity<List<ImageDetails>> loginUser(@RequestBody Registration registration)
	{
		return new ResponseEntity<>(serviceInterface.loginUser(registration),HttpStatus.CREATED);
	}
	
	
}