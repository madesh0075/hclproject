package com.example.Foodie.controller;

import com.example.Foodie.model.Hotel;
import com.example.Foodie.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/add")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @GetMapping("/all")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteHotel(@PathVariable int id) {
        return hotelService.deleteHotel(id);
    }

    @GetMapping("/location/{location}")
    public List<Hotel> getByLocation(@PathVariable String location) {
        return hotelService.getByLocation(location);
    }

    @GetMapping("/rating/{rating}")
    public List<Hotel> getByRating(@PathVariable int rating) {
        return hotelService.getByRating(rating);
    }


}
