package com.RatingService.RatingService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    private String hotelId;
    private String name;
    private String address;
    private String about;

}
