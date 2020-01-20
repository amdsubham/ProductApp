package com.rakuten.training.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;

public class ProductServiceImplTest {

  @Test
  public void addNewProduct_returns_valid_id_when_productValue_GTEQ_MinValue() {
	  //Arrange
	  ProductServiceimpl service = new ProductServiceimpl();
	  Product toBeAdded = new Product("Test", 10000, 1); //10000x1=10000
	  ProductDAO mockDAO = Mockito.mock(ProductDAO.class); //MOCK
	  Product saved = new Product("Test",1000,1);
	  saved.setId(1);
	  Mockito.when(mockDAO.save(toBeAdded)).thenReturn(saved);
	  service.setDao(mockDAO);
	  //Act
	  int id = service.addNewProduct(toBeAdded);
	  //Assert
	  assertTrue(id>0);
  }
  @Test(expected = IllegalArgumentException.class)
  public void addNewProduct_Throws_When_ProductValue_LT_MinValue() {
	  //Arrange
	  ProductServiceimpl service = new ProductServiceimpl();
	  Product toBeAdded = new Product("Test", 999, 1); //9999x1=9999
	  //Act
	  service.addNewProduct(toBeAdded);
	  //Assert
  }
  
  @Test
  public void deleteProduct_if_less_than_Min_Value() {
	  ProductServiceimpl service = new ProductServiceimpl();
	  Product toBeRemoved = new Product("Test", 999, 1);
	  toBeRemoved.setId(1);
	  ProductDAO mockDAO = Mockito.mock(ProductDAO.class);
	  //Product saved = new Product("Test",999,1);
	  //saved.setId(1);
	  Mockito.when(mockDAO.findById(1)).thenReturn(toBeRemoved);
	  
	  service.setDao(mockDAO);
	  service.removeProduct(toBeRemoved.getId());
	  Mockito.verify(mockDAO).deleteByiD(1);
  
  
  }
  @Test(expected = IllegalStateException.class)
  public void Product_is_Not_Valid() {
	  //Arrange
	  ProductServiceimpl service = new ProductServiceimpl();
	  Product toBeRemoved = null; //9999x1=9999
	  //toBeRemoved.setId(1);
	  ProductDAO mockDAO = Mockito.mock(ProductDAO.class);

	  Mockito.when(mockDAO.findById(1)).thenReturn(toBeRemoved);
	  
	  service.setDao(mockDAO);
	  service.removeProduct(1);
	  //Mockito.verify(mockDAO).deleteByiD(1);

  }
  
  
  
  
}
