package com.userService.UserService.repository;

import com.userService.UserService.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  UserRepo extends MongoRepository<User, String> {
}
