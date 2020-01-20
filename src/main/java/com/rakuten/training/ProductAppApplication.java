package com.rakuten.training;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.PublisherDAO;
import com.rakuten.training.dal.ReviewDAO;
import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Publisher;
import com.rakuten.training.domain.Review;
import com.rakuten.training.ui.ProductConsoleUI;

@SpringBootApplication
public class ProductAppApplication {

	public static void main(String[] args) {
		//ApplicationContext springContainer = 
		SpringApplication.run(ProductAppApplication.class, args);
//		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
//		ui.createProductWithUI();
		//ReviewDAO reviewDAO = springContainer.getBean(ReviewDAO.class);
		//Review sample= new Review("self","this is good",5);
		//Review saved = reviewDAO.save(sample, 1);
		//System.out.println("Created Review with id "+saved.getId() ); 
		///////////////////////////////
//		PublisherDAO PublisherDAO = springContainer.getBean(PublisherDAO.class);
//		Publisher sampleone= new Publisher("sshhu","bbsr");
//		Publisher savedone = PublisherDAO.save(sampleone, 1);
//		System.out.println("Created Review with id "+savedone.getId() );
//		ProductDAO productDao = springContainer.getBean(ProductDAO.class);
//		Product p = productDao.findById(1);
//		System.out.println(p.getName() );
//		System.out.println("This Product has"+p.getReview().size()+"reviews" );
		//////
//		ProductDAO productDao = springContainer.getBean(ProductDAO.class);
//		List<Product> p = productDao.findAll();
//		for(int i=0; i<p.size();i++)
//		{
//			System.out.println(p.get(i).getName()); 
//			
//		}
//		productDao.deleteByiD(1);
//		for(int i=0; i<p.size();i++)
//		{
//			System.out.println("After dELETE ---  "+p.get(i).getName()); 
//			
//		}
		
		
		
		
		
		
	}

}
