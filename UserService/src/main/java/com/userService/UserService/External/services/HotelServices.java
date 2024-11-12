package com.userService.UserService.External.services;

import com.userService.UserService.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")
public interface HotelServices {

    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);


}
