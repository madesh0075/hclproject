package com.example.Foodie.repository;

import com.example.Foodie.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Integer> {
    List<Menu> findByHotelId(int hotelId);
}
