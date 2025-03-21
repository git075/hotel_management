# hotel_management# 

## 📌 Overview
This is the backend for a **Hotel Booking Application** built with **Spring Boot & MongoDB**. It provides APIs for:
- User authentication (JWT-based login & registration)
- Hotel room booking system
- Admin panel for managing bookings
- Dynamic pricing of hotel rooms based on demand (Segment Tree )

---

## 🛠️ Tech Stack
- **Java 17**
- **Spring Boot 3**
- **Spring Security & JWT Authentication**
- **MongoDB** (NoSQL database)
- **Maven** (Dependency Management)
- **Lombok** (Boilerplate code reduction)
- **Docker** (For containerization)

---

## ⚙️ Installation & Setup

### 1️⃣ Clone the Repository
```sh
 git clone https://github.com/git075/hotel_management.git
 cd hotel_management
```

### 2️⃣ Configure Environment Variables
Create an `.env` file and add the following:
```
MONGO_URI=mongodb://localhost:27017/hotelApp
JWT_SECRET=your_secret_key_here
```

### 3️⃣ Build & Run the Project
#### **Run in IntelliJ or Command Line**
```sh
mvn clean install
mvn spring-boot:run
```

#### **Run with Docker**
```sh
docker build -t hotel-app-backend .
docker run -p 8080:8080 hotel-app-backend
```

### 4️⃣ API Endpoints
#### **Auth APIs**
| Method | Endpoint          | Description        |
|--------|------------------|--------------------|
| POST   | `/auth/register` | Register a user   |
| POST   | `/auth/login`    | Login & get token |

#### **Booking APIs**
| Method | Endpoint         | Description                   |
|--------|-----------------|-------------------------------|
| POST   | `/booking/book` | Book a hotel room            |
| GET    | `/booking/my-bookings` | Get user bookings |

#### **Admin APIs**
| Method | Endpoint        | Description                |
|--------|----------------|----------------------------|
| GET    | `/admin/bookings` | Get all bookings (Admin) |

---

## 🚀 Deployment Guide
### **Deploy on AWS EC2**
1. **Build the JAR**
   ```sh
   mvn clean package
   ```
2. **Transfer the JAR to EC2**
   ```sh
   scp target/hotel-app.jar ec2-user@your-ec2-ip:/home/ec2-user/
   ```
3. **Run the JAR on EC2**
   ```sh
   java -jar hotel-app.jar
   ```

---

## 📌 License
This project is licensed under the MIT License.

