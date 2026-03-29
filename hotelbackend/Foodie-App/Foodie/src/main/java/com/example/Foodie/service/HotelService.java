package com.example.Foodie.service;

import com.example.Foodie.model.Hotel;
import com.example.Foodie.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepo hotelRepo;

    public Hotel addHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    public String deleteHotel(int id) {
        hotelRepo.deleteById(id);
        return "Deleted Successfully";
    }

    public List<Hotel> getByLocation(String location) {
        return hotelRepo.findByLocation(location);
    }

    public List<Hotel> getByRating(int rating) {
        return hotelRepo.findByRating(rating);
    }
}
