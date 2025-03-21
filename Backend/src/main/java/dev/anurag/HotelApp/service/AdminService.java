package dev.anurag.HotelApp.service;

import dev.anurag.HotelApp.Repository.BookingRepo;
import dev.anurag.HotelApp.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
   private BookingRepo bookingRepo;

    public List<Booking> getAllBookings(){
        return bookingRepo.findAll();
    }

    public void deleteBooking(Long id){
        bookingRepo.deleteById(id);

    }


}
