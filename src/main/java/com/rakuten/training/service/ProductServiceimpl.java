 package com.rakuten.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.ProductDAOinMemimpl;
import com.rakuten.training.domain.Product;
@Service("serviceObj")

public class ProductServiceimpl implements ProductService {
	ProductDAO dao;//= new ProductDAOinMemimpl();
	
	
@Autowired	
public void setDao(ProductDAO dao) {
    this.dao = dao;
  }
	
	

  @Override
  public int addNewProduct(Product toBeAdded) {
	  if(toBeAdded.getPrice()* toBeAdded.getQoh()>=1000)
	  {
		  Product added = dao.save(toBeAdded);
		  return added.getId();
	  }
	  else
	  {
		  throw new IllegalArgumentException("The monetory value of product is <1000");
	  }

  }

  @Override
  public void removeProduct(int id) {
	  Product existing = dao.findById(id);
	  if(existing !=null)
	  {
		  if(existing.getPrice()*existing.getQoh()>=1000)
		  {
			  throw new IllegalStateException("Moneytory Value>1000.can't delete.");
			  
		  }
		  else
		  {
			  dao.deleteByiD(id);
		  }
		  
		  
	  }
	  else
	  {
		  throw new IllegalStateException(" -------- ");
	  }

    // TODO Auto-generated method stub
    
  }

  @Override
  public List<Product> findAll() {
    // TODO Auto-generated method stub
    return dao.findAll();
  }

  @Override
  public Product findByid(int id) {
    // TODO Auto-generated method stub
    return dao.findById(id);
  }
	
	
	
	
	
	
	
}
