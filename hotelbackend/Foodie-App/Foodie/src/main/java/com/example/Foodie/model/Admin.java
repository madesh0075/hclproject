    package com.example.Foodie.model;

    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import jakarta.persistence.*;

    @Entity
    public class Admin {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String username;
        private String email;
        private String password;
        private String role = "ADMIN";

        // 🔥 RELATION WITH HOTEL
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "hotel_id")
        @JsonIgnoreProperties("admin") // prevents infinite loop
        private Hotel hotel;

        // ✅ GETTERS & SETTERS

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }


        public Hotel getHotel() {
            return hotel;
        }

        public void setHotel(Hotel hotel) {
            this.hotel = hotel;
        }
    }