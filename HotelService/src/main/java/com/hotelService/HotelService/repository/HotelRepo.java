package com.hotelService.HotelService.repository;

import com.hotelService.HotelService.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends MongoRepository<Hotel, String> {
}
