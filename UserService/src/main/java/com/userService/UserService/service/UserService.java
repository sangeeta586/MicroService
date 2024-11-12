package com.userService.UserService.service;

import com.userService.UserService.External.services.HotelServices;
import com.userService.UserService.model.Hotel;
import com.userService.UserService.model.Rating;
import com.userService.UserService.model.User;
import com.userService.UserService.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate ;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private HotelServices hotelServices;

    public User createUser(User user) {
        return userRepo.save(user);
    }


    public User getUserById(String id) {
        User user = userRepo.findById(id).orElse(null);
        Rating[] arr = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
         logger.info("{}",arr);
         List<Rating> ratings =  Arrays.stream(arr).toList();
         List<Rating> ratingList = ratings.stream().map(rating -> {
            // ResponseEntity<Hotel> hotels  = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
             Hotel hotel =  hotelServices.getHotel(rating.getHotelId());
             rating.setHotel(hotel);
             return rating;
         }).collect(Collectors.toList());
         user.setRatings(ratings);
        return user;
    }


    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


    public User updateUser(String id, User updatedUser) {

        Optional<User> existingUser = userRepo.findById(id);

        if (existingUser.isPresent()) {
            User user = existingUser.get();

            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            user.setEmail(updatedUser.getEmail());


            return userRepo.save(user);
        } else {
            return null;
        }
    }


    public boolean deleteUser(String id) {
        Optional<User> user = userRepo.findById(id);

        if (user.isPresent()) {
            userRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
