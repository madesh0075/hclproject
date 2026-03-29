package com.example.Foodie.repository;

import com.example.Foodie.model.Hotel;
import com.example.Foodie.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {

    List<Hotel> findByLocation(String location);

    List<Hotel> findByRating(int rating);
}
