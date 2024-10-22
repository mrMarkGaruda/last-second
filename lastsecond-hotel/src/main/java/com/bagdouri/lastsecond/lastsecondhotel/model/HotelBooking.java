package com.bagdouri.lastsecond.lastsecondhotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerFirstName;
    private String customerLastName;
    private String customerIdNumber;
    private String hotelName;
    private LocalDateTime checkInDateTime;
    private LocalDateTime checkOutDateTime;
    private double price;

    // Getters and setters...
}
