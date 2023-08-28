package com.example.WebAppProject;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.example.WebAppProject.config.auth.User;
//import com.example.WebAppProject.repository.UserRepository;


@SpringBootApplication
public class WebAppProjectApplication {
//	@Autowired
//	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(WebAppProjectApplication.class, args);
		System.out.println("hello");
	}
//	 @PostConstruct
//	    public void initUsers() {
//	        List<User> users = Stream.of(
//	                new User(101, "javatechie", "password", "javatechie@gmail.com"),
//	                new User(102, "user1", "pwd1", "user1@gmail.com"),
//	                new User(103, "user2", "pwd2", "user2@gmail.com"),
//	                new User(104, "user3", "pwd3", "user3@gmail.com"),
//	                new User(105,"user3","pwd4","user@123")
//	        ).collect(Collectors.toList());
//	        repository.saveAll(users);
//	    }

}
