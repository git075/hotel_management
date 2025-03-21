package dev.anurag.HotelApp.Repository;

import dev.anurag.HotelApp.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends MongoRepository<Booking, Long> {
}
