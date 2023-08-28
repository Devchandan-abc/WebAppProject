package com.example.WebAppProject.config.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.WebAppProject.service.ServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
//extract the token and validate the user
public class JwtFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomUserDetailsService service1;

	// extract the string from header and get the username and password 
	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {

		String authorizationHeader = httpServletRequest.getHeader("Authorization");
		// get the header from this

		String token = null;
		String userName = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
			// checking that it is null and starts with Bearer and get the token
			token = authorizationHeader.substring(7);
			// will get the other string
			userName = jwtUtil.extractUsername(token);
		}

		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = service1.loadUserByUsername(userName);
//getting the userDetails object 
			if (jwtUtil.validateToken(token, userDetails)) {
				//validating the token
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}
