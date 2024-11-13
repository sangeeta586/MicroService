package com.userService.UserService.controller;

import com.userService.UserService.model.User;
import com.userService.UserService.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }
//creating fallback methode for circuit breaker
   public User ratingHotelFallback(@PathVariable String id, Exception ex) {
       logger.info("fallback is executed because service is down ");
        User user = User.builder().email("s@gmail.com").username("s").password("123").build();
        return user;
   }
    @GetMapping
    public List<User> getAllUsers() {  
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}
