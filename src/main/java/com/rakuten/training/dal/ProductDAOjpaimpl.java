package com.rakuten.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.engine.spi.ExecuteUpdateResultCheckStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.domain.Product;

@Repository
@Transactional
public class ProductDAOjpaimpl implements ProductDAO {
	@Autowired
	EntityManager em;

  @Override
  public Product save(Product toBeSaved) {
	  em.persist(toBeSaved);
    // TODO Auto-generated method stub
    return toBeSaved;
  }

  @Override
  public Product findById(int id) {
	  Product p = em.find(Product.class,1);
	  //System.out.println("This Product has"+p.getReview().size()+"reviews" ); 
    // TODO Auto-generated method stub
    return em.find(Product.class, id);
  }

  @Override
  public List<Product> findAll() {
    // TODO Auto-generated method stub
	  Query q = em.createQuery("select p from Product as p ");
	  List<Product> all = q.getResultList();
    return all;
  }

  @Override
  public void deleteByiD(int id) {
	  Product p = em.getReference(Product.class, id);
	  em.remove(p);
//	  Query q = em.createQuery("delete from Product as p where p.id=:idParam");
//	  q.setParameter("idParam", id);
//	  q.executeUpdate();
    
    
  }
	
	
	
	
}
