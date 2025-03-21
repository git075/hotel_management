package dev.anurag.HotelApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "bookings")
@Data
@NoArgsConstructor
public class Booking {
    @Id
    private String id;

    @DBRef
    private User user;

    private String roomType;
    private Date startDate;
    private Date endDate;
    private double totalPrice;
    private String status = "confirmed";
}