package com.rakuten.training.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakuten.training.domain.Product;
import com.rakuten.training.service.ProductService;
import com.rakuten.training.service.ProductServiceimpl;
@Component("uiObj")
public class ProductConsoleUI {

  ProductService service; // = new ProductServiceimpl();
@Autowired
  public void setService(ProductService service) {
    this.service = service;
  }

  public void createProductWithUI() {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter name:");
    String name = s.nextLine();
    System.out.println("Enter Price:");
    float price = Float.parseFloat(s.nextLine());
    System.out.println("Enter Qoh");
    int qoh = Integer.parseInt(s.nextLine());
    Product p = new Product(name, price, qoh);
    int id = service.addNewProduct(p);
    System.out.println("Created Product with id :" + id);
  }
}