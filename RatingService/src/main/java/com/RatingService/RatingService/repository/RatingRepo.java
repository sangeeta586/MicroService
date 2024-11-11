package com.RatingService.RatingService.repository;

import com.RatingService.RatingService.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepo extends MongoRepository<Rating, String> {
}
