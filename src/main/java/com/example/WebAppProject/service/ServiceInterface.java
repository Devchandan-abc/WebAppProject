package com.example.WebAppProject.service;

import com.example.WebAppProject.entity.ImageDetails;
import com.example.WebAppProject.entity.Registration;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UserDetails;
public interface ServiceInterface {

	Registration saveUser(Registration registration);

	String uplaoadImage(MultipartFile file, long id) throws IOException;

	List<ImageDetails> loginUser(Registration registration);

	String deleteImage(long id);

	List<ImageDetails> getAll();

	ImageDetails getImagesById(long id);

	  //  Resource downloadImage(Long id);
   public byte[] downloadImage(long id);
  // public UserDetails loadUserByUsername(String username) ;

//public UserDetails loadUserByUsername(String userName);

}
