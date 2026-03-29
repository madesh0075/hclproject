package com.example.Foodie.controller;
import com.example.Foodie.model.Menu;
import com.example.Foodie.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping("/add")
    public Menu addMenu(@RequestBody Menu menu) {
        return menuService.addMenu(menu);
    }

    @GetMapping("/all")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/hotel/{hotelId}")
    public List<Menu> getMenuByHotel(@PathVariable int hotelId) {
        return menuService.getMenuByHotel(hotelId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMenu(@PathVariable int id) {
        return menuService.deleteMenu(id);
    }

}
