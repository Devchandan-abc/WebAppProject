package com.example.WebAppProject.entity;


import java.util.Collection;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "name is required")
	private String name;
	@NotEmpty(message = "Uname is required")
	private String userName;
	@NotEmpty(message = "password is required")
	private String password;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private ImageDetails images;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Registration [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password + "]";
	}
	public Registration(Long id, String name, String userName, String password) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
	}
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return this.userName;
//	}
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	
	

}
