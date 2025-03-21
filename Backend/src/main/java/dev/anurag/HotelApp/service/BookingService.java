package dev.anurag.HotelApp.service;


import dev.anurag.HotelApp.Repository.BookingRepo;
import dev.anurag.HotelApp.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private DynamicPriceService dynamicPricingService;
    private int[] demandData = {5, 12, 18, 7, 9, 15};

    public Booking bookRoom(Booking booking) {
        dynamicPricingService.initialize(demandData);
        int demandFactor = dynamicPricingService.getTotalDemand(2, 4);
        double dynamicPrice = dynamicPricingService.calculatePrice(booking.getTotalPrice(), demandFactor);

        booking.setTotalPrice(dynamicPrice);

        return bookingRepo.save(booking);
    }

    public List<Booking> getAllBookings(){
        return bookingRepo.findAll();
    }

    public Booking createBooking(Booking booking){
        return bookingRepo.save(booking);
    }
}
