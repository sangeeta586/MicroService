package com.hotelService.HotelService.service;


import com.hotelService.HotelService.model.Hotel;
import com.hotelService.HotelService.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepo hotelRepo;  

    // Create or Save a new hotel
    public Hotel createHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    // Update an existing hotel
    public Hotel updateHotel(String hotelId, Hotel hotelDetails) {
        // Find the hotel by its ID
        Optional<Hotel> existingHotelOpt = hotelRepo.findById(hotelId);

        if (existingHotelOpt.isPresent()) {
            Hotel existingHotel = existingHotelOpt.get();
            // Update the details of the existing hotel
            existingHotel.setName(hotelDetails.getName());
            existingHotel.setAddress(hotelDetails.getAddress());
            existingHotel.setAbout(hotelDetails.getAbout());
            return hotelRepo.save(existingHotel);
        } else {
            // If hotel not found, you can throw an exception or handle as needed
            throw new RuntimeException("Hotel not found with ID " + hotelId);
        }
    }

    // Get a hotel by its ID
    public Hotel getHotelById(String hotelId) {
        return hotelRepo.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with ID " + hotelId));
    }

    // Get all hotels
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    // Delete a hotel by its ID
    public void deleteHotel(String hotelId) {
        Optional<Hotel> hotel = hotelRepo.findById(hotelId);
        if (hotel.isPresent()) {
            hotelRepo.deleteById(hotelId);
        } else {
            throw new RuntimeException("Hotel not found with ID " + hotelId);  // Or handle as needed
        }
    }
}

