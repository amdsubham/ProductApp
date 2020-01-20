package com.rakuten.training.service;

import java.util.List;
import com.rakuten.training.domain.Review;

public interface ReviewService {

	int addNewReviewToProduct(int id,Review toBeAdded);
	void removeReview(int id);
	//public List<Review> getByProductId(int id);
	Review findByid(int id);
	//public List<Review> getByProductId(int productId);
		List<Review> getByProductId(int productId);
    
}
