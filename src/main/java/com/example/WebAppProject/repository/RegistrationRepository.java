package com.example.WebAppProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WebAppProject.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	Optional<Registration> findByUserName(String userName);

}
