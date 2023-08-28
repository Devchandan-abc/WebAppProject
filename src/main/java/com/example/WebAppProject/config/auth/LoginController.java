package com.example.WebAppProject.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
@RestController
public class LoginController {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
	            );
	            //authenticate that it is right user or not we have predefined class 
	            //UsernamePasswordAuthenticationToken
	        } catch (Exception ex) {
	            throw new Exception("inavalid username/password");
	        }
	        //then only generate the token as string
	        return jwtUtil.generateToken(authRequest.getUserName());
	    }
}

