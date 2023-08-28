package com.example.WebAppProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WebAppProject.entity.ImageDetails;

public interface ImageDetailsRepository extends JpaRepository<ImageDetails, Long>{
	
	Optional<ImageDetails> findByFileName(String fileName);

}
