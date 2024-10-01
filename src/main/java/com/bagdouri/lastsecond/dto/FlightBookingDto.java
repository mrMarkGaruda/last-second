package com.bagdouri.lastsecond.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingDto {

    private Long id;
    private String customerFirstName;
    private String customerLastName;
    private String customerIdNumber;
    private String departureAirport;
    private LocalDateTime departureDateTime;
    private String arrivalAirport;
    private LocalDateTime arrivalDateTime;
    private double price;
}
