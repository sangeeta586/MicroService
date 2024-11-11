package com.userService.UserService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "ratings")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private double rating;
}
