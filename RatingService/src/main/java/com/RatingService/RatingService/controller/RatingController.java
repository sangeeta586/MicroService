package com.RatingService.RatingService.controller;

import com.RatingService.RatingService.model.Rating;
import com.RatingService.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createOrUpdateRating(@RequestBody Rating rating) {
        Rating savedRating = ratingService.createOrUpdateRating(rating);
        return ResponseEntity.ok(savedRating);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String id) {
        Optional<Rating> rating = ratingService.getRatingById(id);
        return rating.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable String id) {
        boolean deleted = ratingService.deleteRating(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllRatings() {
        ratingService.deleteAllRatings();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getratingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getratingByHotelId(hotelId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable String id, @RequestBody Rating rating) {
        return ratingService.getRatingById(id)
                .map(existingRating -> {
                     Rating updatedRating = ratingService.updateRating(id, rating);
                    return ResponseEntity.ok(updatedRating);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

