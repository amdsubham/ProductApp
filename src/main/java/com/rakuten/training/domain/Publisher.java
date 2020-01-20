package com.rakuten.training.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Publisher {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int id ;
	String name;
	String city;
	@ManyToOne
	@JoinColumn(name="product_id")
	Product product;
	
	 public Publisher() {
    // TODO Auto-generated constructor stub
  }
	 
  public Publisher(String name, String city) {
    super();
    this.name = name;
    this.city = city;

  }
  


public Product getProduct() {
return product;}

public void setProduct(Product product) {
this.product = product;}

public int getId() {
return id;}

public void setId(int id) {
this.id = id;}

public String getName() {
return name;}

public void setName(String name) {
this.name = name;}

public String getCity() {
return city;}

public void setCity(String city) {
this.city = city;}
}
