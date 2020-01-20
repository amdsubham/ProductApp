package com.rakuten.training.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Review;
import com.rakuten.training.service.ProductService;
import com.rakuten.training.service.ReviewService;

public class ReviewController {
	@Autowired
	ReviewService ser;
	@Autowired
	ProductService  service;
	
	
	
	
	@GetMapping("/products/{id}/reviews")
	public ResponseEntity<List<Review>> getReviewForProduct(@PathVariable("id")int id)
	{
		Product p = service.findByid(id);
		if(p==null)
		{
			return new ResponseEntity<List<Review>>(HttpStatus.NOT_FOUND);
		}
		List<Review> reviews = ser.getByProductId(id);
		return new ResponseEntity<List<Review>>(reviews,HttpStatus.OK);
		
	}

	@PostMapping("/products/{id}/reviews")
	public ResponseEntity<Review> addReviewToProduct(@PathVariable("id") int id , @RequestBody Review review)
	{
		try {
			int idS = ser.addNewReviewToProduct(id, review);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/products/"+idS+"/reviews/"+idS));
			return new ResponseEntity<Review>(review,headers,HttpStatus.CREATED);
			
      
      
    } catch (NoSuchProductException e) {
    	
      // TODO: handle exception
    	return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
    }
		
	}
}
