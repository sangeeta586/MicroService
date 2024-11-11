package com.userService.UserService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(value = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    private String userId;
    private String username;
    private String password;
    private String email;
    private List<Rating> ratings = new ArrayList<Rating>();

}
  