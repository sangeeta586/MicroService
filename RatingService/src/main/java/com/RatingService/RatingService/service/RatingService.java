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

    public Rating updateRating(String id, Rating rating) {
       Optional<Rating> existingRatingOpt = ratingRepository.findById(id);

        if (existingRatingOpt.isPresent()) {
            Rating existingRating = existingRatingOpt.get();
            existingRating.setHotelId(rating.getHotelId());
            existingRating.setRating(rating.getRating());
            existingRating.setHotel(rating.getHotel());
            return ratingRepository.save(existingRating);
        }
        return null;
    }
    public void deleteAllRatings() {
        ratingRepository.deleteAll();
    }

   public List<Rating> getratingByUserId(String userId){
        return  ratingRepository.findByUserId(userId);
    }
   public List<Rating> getratingByHotelId(String hotelId){
        return  ratingRepository.findByHotelId(hotelId);
    }
}

