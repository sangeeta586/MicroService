package com.userService.UserService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    private String hotelId;
    private String name;
    private String address;
    private String about;

}
