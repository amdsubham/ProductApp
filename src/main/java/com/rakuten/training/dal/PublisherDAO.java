package com.rakuten.training.dal;

import java.util.List;

import com.rakuten.training.domain.Publisher;


public interface PublisherDAO {

	  Publisher findById(int id);

	  Publisher save(Publisher toBeSaved,int id);

	  void deleteById(int id);

	  List<Publisher> findAll();
}