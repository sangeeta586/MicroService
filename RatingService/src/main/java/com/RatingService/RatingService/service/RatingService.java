package com.RatingService.RatingService.service;

import com.RatingService.RatingService.model.Rating;
import com.RatingService.RatingService.repository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepo ratingRepository;


    public Rating createOrUpdateRating(Rating rating) {
        return ratingRepository.save(rating);
    }


    public Optional<Rating> getRatingById(String id) {
        return ratingRepository.findById(id);
    }


    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }


    public boolean deleteRating(String id) {
        if (ratingRepository.existsById(id)) {
            ratingRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public void deleteAllRatings() {
        ratingRepository.deleteAll();
    }
}
