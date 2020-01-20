package com.rakuten.training.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Publisher;
import com.rakuten.training.domain.Review;

public class PublisherDAOJpaImpl implements PublisherDAO {
	 @Autowired
	 EntityManager em;

	  @Override
	  public Publisher findById(int id) {
	    return em.find(Publisher.class, id);
	  }

	  @Override
	  public Publisher save(Publisher toBeSaved,int productId) {
		Product p = em.find(Product.class, productId);
		toBeSaved.setProduct(p);
	    em.persist(toBeSaved);
	    return toBeSaved;
	  }

	  @Override
	  public void deleteById(int id) {
		  Publisher r = em.find(Publisher.class, id);
	    em.remove(r);
	  }

	  @Override
	  public List<Publisher> findAll() {
	    return null;

	
	
	
	
	  }
}

