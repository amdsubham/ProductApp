package com.rakuten.training.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.dal.ReviewDAO;
import com.rakuten.training.dal.ReviewDAOJpaImpl;
import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Review;
import com.rakuten.training.service.ProductService;
import com.rakuten.training.service.ReviewService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService  service;

	
	//@RequestMapping(method = RequestMethod.GET,value= "/products")
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		return service.findAll();
	}
	@GetMapping("/products/{prodid}")
	public ResponseEntity<Product> getProductById(@PathVariable("prodid")int id)
	{
		Product p = service.findByid(id);
		if(p  != null )
		{
			return new ResponseEntity<Product>(p,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Product>(p,HttpStatus.NOT_FOUND);
			
		}
		//return p;
		
	}
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product toBeAdded)
	{
		try {
			int id = service.addNewProduct(toBeAdded);
			System.out.println("add_pROD"+id ); 
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/products/"+id));
			return new ResponseEntity<Product>(headers,HttpStatus.CREATED);
			
		}
		catch(IllegalArgumentException e)
		{
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
		
		
		
		
	}
//	@DeleteMapping("/products}")
//	public ResponseEntity<Product> delete_Product_By_Id(@PathVariable("prodid")int id)
//	{
//		try
//		{
//			Product p = service.findByid(id);
//			//HttpHeaders headers = new HttpHeaders();
//			//headers.remove(URI.create("/products/"+id));
//			service.removeProduct(id);
//			return new ResponseEntity<Product>(HttpStatus.OK);//setLocation(URI.create("/products/"+id));
//		}
//		catch(IllegalArgumentException e)
//		{
//			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
//		}
//
//		
//	}
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProductByid(@PathVariable("id") int id) {
		Product currentProduct = service.findByid(id);
		if (currentProduct == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		service.removeProduct(id);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
	

}

	
	
	

