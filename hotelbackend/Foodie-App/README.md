# Foodie-App
# 🍽️ Foodie App (Spring Boot Backend)

## 🚀 Overview

Foodie App is a backend REST API built using **Spring Boot** that simulates a food ordering system like Swiggy/Zomato.

It supports:

* 👤 User & 👨‍💼 Admin authentication
* 🏨 Hotel management
* 🍽️ Menu management
* 🛒 Order placement & cancellation
* 📧 Email notifications after order
* 🔐 Role-based security using Spring Security

---

## 🧱 Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Spring Security
* MySQL
* Java Mail Sender
* Maven

---

## 📂 Project Structure

```
controller/   → REST APIs
service/      → Business logic
repository/   → Database access
model/        → Entity classes
configuration/→ Security config
```

---

## 🔐 Authentication & Authorization

* Passwords are encrypted using **BCrypt**
* Role-based access:

  * `ADMIN` → manage system
  * `USER` → place orders

### 🔑 Authentication Type:

* Basic Authentication (email + password)

---

## 📌 API Endpoints

### 👨‍💼 Admin

* `POST /admin/register` → Register admin
* `POST /admin/login` → Login admin
* `GET /admin/showAll` → View all admins

### 👤 User

* `POST /user/adduser` → Register user
* `POST /user/user-login` → Login user
* `GET /user/show-user` → Get all users

### 🏨 Hotel

* `POST /hotel/add` → Add hotel
* `GET /hotel/all` → Get all hotels
* `DELETE /hotel/delete/{id}` → Delete hotel
* `GET /hotel/location/{location}` → Filter by location
* `GET /hotel/rating/{rating}` → Filter by rating

### 🍽️ Menu

* `POST /menu/add` → Add menu item
* `GET /menu/all` → Get all menu items
* `GET /menu/hotel/{hotelId}` → Get menu by hotel
* `DELETE /menu/delete/{id}` → Delete menu item

### 🛒 Order

* `POST /order/add-order` → Place order
* `PUT /order/cancel-order/{id}` → Cancel order

---

## 🔄 Application Flow

1. User/Admin registers
2. Login with credentials
3. User views hotels & menu
4. User places order
5. Order stored in DB
6. Email sent to user

---

## 📧 Email Feature

* Sends confirmation mail after order
* Includes:

  * Food name
  * Price

---

## ⚙️ Setup Instructions

### 1. Clone Repository

```
git clone <your-repo-link>
cd foodie-app
```

### 2. Configure Database (application.properties)

```
spring.datasource.url=jdbc:mysql://localhost:3306/foodie
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run Application

```
mvn spring-boot:run
```

---

## 🧪 Testing

Use **Postman** to test APIs.

Example:

* Register user → `/user/adduser`
* Login → `/user/user-login`
* Add hotel → `/hotel/add`

---

## ⚠️ Known Issues

* Admin login does not validate password properly (can be improved)
* Basic Auth used instead of JWT
* No global exception handling

---

## 🚀 Future Improvements

* JWT Authentication
* Swagger API Documentation
* Frontend Integration (React)
* Order history for users
* Payment gateway integration

---

## 💡 Author

**Menaka A**

---

## ⭐ Project Highlights

* Clean layered architecture
* Role-based security
* Email integration
* Real-world backend design

---
