package com.userService.UserService.External.services;

import com.userService.UserService.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="RATINGSERVICE")
public interface RatingServices {

    @GetMapping("/ratings/{ratingId}")
    public Rating getRating(@PathVariable String ratingId);

    @PostMapping("/ratings")
    public Rating createRating(Rating rating);
    @PutMapping("/ratings/update/{ratingId}")
    public Rating updateRating(@PathVariable String ratingId, Rating rating);
}
