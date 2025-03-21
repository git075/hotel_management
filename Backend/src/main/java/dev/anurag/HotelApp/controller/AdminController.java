package dev.anurag.HotelApp.controller;

import dev.anurag.HotelApp.service.AdminService;
import dev.anurag.HotelApp.service.BookingService;
import dev.anurag.HotelApp.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(adminService.getAllBookings());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        adminService.deleteBooking(id);
        return ResponseEntity.ok("Booking deleted successfully");
    }
}