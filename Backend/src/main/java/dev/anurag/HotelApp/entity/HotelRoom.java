package dev.anurag.HotelApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "hotel_rooms")
public class HotelRoom {
    @Id
    private String id;
    private String roomNumber;
    private String type; // e.g., Deluxe, Suite, etc.
    private double price;
    private boolean available;
    private int demand; // For dynamic pricing logic
}
