package com.userService.UserService.service;

import com.userService.UserService.model.User;
import com.userService.UserService.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    // Create a new user
    public User createUser(User user) {
        return userRepo.save(user);
    }

    // Get a user by ID
    public User getUserById(String id) {
        Optional<User> user = userRepo.findById(id); // Returns an Optional<User>
        return user.orElse(null); // If not found, returns null or you can throw an exception
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // Update an existing user
    public User updateUser(String id, User updatedUser) {
        // Check if user exists by ID
        Optional<User> existingUser = userRepo.findById(id);

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            // Update fields of the existing user object
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            user.setEmail(updatedUser.getEmail());

            // Save the updated user back to the repository
            return userRepo.save(user);
        } else {
            return null; // Or throw a custom exception if the user is not found
        }
    }

    // Delete a user by ID
    public boolean deleteUser(String id) {
        Optional<User> user = userRepo.findById(id);

        if (user.isPresent()) {
            userRepo.deleteById(id); // Delete user by ID
            return true;
        } else {
            return false; // User not found
        }
    }
}
