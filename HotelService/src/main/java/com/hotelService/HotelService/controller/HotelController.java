package com.hotelService.HotelService.controller;

import com.hotelService.HotelService.model.Hotel;
import com.hotelService.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;    

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    // Create a new hotel (POST request)
    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.createHotel(hotel);
        return ResponseEntity.ok(createdHotel);
    }

    // Update an existing hotel (PUT request)
    @PutMapping("/update/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String id, @RequestBody Hotel hotelDetails) {
        Hotel updatedHotel = hotelService.updateHotel(id, hotelDetails);
        return ResponseEntity.ok(updatedHotel);
    }

    // Get a hotel by ID (GET request)
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {
        Hotel hotel = hotelService.getHotelById(id);
        return ResponseEntity.ok(hotel);
    }

    // Get all hotels (GET request)
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    // Delete a hotel (DELETE request)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable String id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }

}
