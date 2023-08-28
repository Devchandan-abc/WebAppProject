package com.example.WebAppProject.controller;
import com.example.WebAppProject.entity.ImageDetails;
import com.example.WebAppProject.repository.ImageDetailsRepository;
import com.example.WebAppProject.service.ServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ByteArrayResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ImageDetailsController {
	@Autowired
	private ServiceInterface serviceInterface;
	@Autowired
	private ImageDetailsRepository imageRepo;
	@PostMapping("/image")
	 public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file, @RequestParam(name = "id", required = false, defaultValue = "0") long id) throws IOException
	 {
		 return new ResponseEntity<>(serviceInterface.uplaoadImage(file,id),HttpStatus.CREATED);
	 }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteImage(@PathVariable("id") long id)
	{
		return new ResponseEntity<>(serviceInterface.deleteImage(id),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	
	public ResponseEntity<List<ImageDetails>> getAllImages()
	{
		return new ResponseEntity<>(serviceInterface.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<ImageDetails> getImagesBasedOnId(@PathVariable("id") long id)
	{
		return new ResponseEntity<>(serviceInterface.getImagesById(id),HttpStatus.OK);
	}
	
	
/*@GetMapping("/{imageId}")
public ResponseEntity<Resource> downloadImage(@PathVariable Long imageId) {
	  Resource imageResource = serviceInterface.downloadImage(imageId);

      if (imageResource != null) {
          ImageDetails imageDetails = getImageDetailsById(imageId);

          HttpHeaders headers = new HttpHeaders();
          headers.setContentType(MediaType.parseMediaType(imageDetails.getContent())); // Set correct content type

          return ResponseEntity.ok()
              .headers(headers)
              .body(imageResource);
      } else {
          return ResponseEntity.notFound().build();
      }
  }

  // Fetch ImageDetails by ID - implement this method based on your repository
  private ImageDetails getImageDetailsById(Long imageId) {
      // Implement logic to retrieve ImageDetails by ID from the repository
      // Return an ImageDetails instance or null if not found
	  Optional<ImageDetails> imageDetailsOptional = imageRepo.findById(imageId);

	    if (imageDetailsOptional.isPresent()) {
	        return imageDetailsOptional.get();
	    } else {
	        throw new FileNotFoundException("Image with ID " + imageId + " not found");
	    }
  }*/
	@GetMapping("/pdf/{id}")
	public ResponseEntity<?> downloadPdf(@PathVariable long id){
		byte[] imageData=serviceInterface.downloadImage(id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("application/pdf"))
		.body(imageData);

	}
	@GetMapping("/image/{id}")
	public ResponseEntity<?> downloadImage(@PathVariable long id){
		byte[] imageData=serviceInterface.downloadImage(id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/jpeg"))
		//		.contentType(MediaType.valueOf("image/jpeg"))
//				.contentType(MediaType.valueOf("image/png"))
//				.contentType(MediaType.valueOf("image/jpeg"))
		.body(imageData);

	}
}


