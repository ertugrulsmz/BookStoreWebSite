package com.bookstore.dao;



import java.util.Date;
import java.util.List;


import com.bookstore.entity.Review;

public class ReviewDao extends JpaDao<Review> implements GenericDao<Review> {
	
	public Review create(Review review) {
		review.setReview_time(new Date());
		return super.create(review);
	}
	
	@Override
	public Review get(Object id) {
		return super.find(Review.class,id);
	}
	
	public List<Review> lastReviews()
	{
		return super.listNewObject("Review.findAll",0,3);
	}
	

	@Override
	public void delete(Object id) {
		 super.delete(Review.class,id);
		
	}

	@Override
	public List<Review> listall() {
		return super.findAll("Review.findAll");
	}

	@Override
	public long count() {
		return super.count("Review.countAll");
	}
	
	
}
