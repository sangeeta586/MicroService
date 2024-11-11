package com.RatingService.RatingService.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "ratings")
@Data
@Setter
@Getter
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private Integer rating;
}
