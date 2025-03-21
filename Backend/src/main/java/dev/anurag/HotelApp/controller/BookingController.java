package dev.anurag.HotelApp.controller;

import dev.anurag.HotelApp.service.BookingService;
import dev.anurag.HotelApp.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<?> bookRoom(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.bookRoom(booking));
    }

    @GetMapping("/my-bookings")
    public ResponseEntity<List<Booking>> getMyBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }
}