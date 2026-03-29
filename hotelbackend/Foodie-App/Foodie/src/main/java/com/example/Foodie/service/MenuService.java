package com.example.Foodie.service;

import com.example.Foodie.model.Hotel;
import com.example.Foodie.model.Menu;
import com.example.Foodie.repository.HotelRepo;
import com.example.Foodie.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepo menurepo;

    @Autowired
    private HotelRepo hotelRepo;

    // ✅ ADD MENU (FIXED)
    public Menu addMenu(Menu menu) {

        System.out.println("MENU RECEIVED: " + menu);

        if (menu.getHotel() == null) {
            throw new RuntimeException("Hotel is NULL from request ❌");
        }

        int hotelId = menu.getHotel().getId();
        System.out.println("HOTEL ID: " + hotelId);

        Hotel hotel = hotelRepo.findById(hotelId).orElse(null);

        if (hotel == null) {
            throw new RuntimeException("Hotel NOT FOUND in DB ❌ ID: " + hotelId);
        }

        menu.setHotel(hotel);

        return menurepo.save(menu);
    }

    // ✅ GET ALL
    public List<Menu> getAllMenus() {
        return menurepo.findAll();
    }

    // ✅ GET BY HOTEL
    public List<Menu> getMenuByHotel(int hotelId) {
        return menurepo.findByHotelId(hotelId);
    }

    // ✅ DELETE
    public String deleteMenu(int id) {
        menurepo.deleteById(id);
        return "Menu removed";
    }
}