package com.rakuten.training.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.ReviewDAO;
import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Review;
import com.rakuten.training.web.NoSuchProductException;
@Service
@Transactional
public class ReviewServiceimpl implements ReviewService {
	
	
	@Autowired
	ReviewDAO dao;//= new ProductDAOinMemimpl();
	@Autowired
	ProductDAO productDao;
	
	@Autowired	
	public void setDao(ReviewDAO dao) {
	    this.dao = dao;
	  }

  @Override
  public int addNewReview(Review toBeAdded, int id) {
	  System.out.println( toBeAdded.getAuthor()); 
	  
	  
	  if(toBeAdded.getAuthor()!=null)
	  {
		  Review added = dao.save(toBeAdded,toBeAdded.getId());
		  System.out.println( toBeAdded.getId()); 
		  return added.getId();
	  }
	  else
	  {
		  throw new IllegalArgumentException("Due to Some Reason");
	  }
  }

  @Override
  public void removeReview( int id )  {
	  Review existing = dao.findById(id);
	  if(existing !=null)
	  {
		
			  dao.deleteById(id);
		  
		  
		  
	  }
	  else
	  {
		  throw new IllegalStateException(" -------- ");
	  }
    
  }

  @Override
  public List<Review> findAll() {
    // TODO Auto-generated method stub
	  return dao.findAll();
  }

  @Override
  public Review findByid(int id) {
    // TODO Auto-generated method stub
	  return dao.findById(id);
  }

@Override public int addNewReviewToProduct(int id,Review toBeAdded){
	Product product = productDao.findById(id);
	if(product == null) {
		throw new NoSuchProductException();
	}
	toBeAdded.setProduct(product);
	Review added = dao.save(toBeAdded);
	return added.getId();
	
	
	
	// TODO Auto-generated method stub
}

@Override public List<Review> getByProductId(int id){// TODO Auto-generated method stub
return dao.findByProductId(id);}
		
	
		
		
	}
