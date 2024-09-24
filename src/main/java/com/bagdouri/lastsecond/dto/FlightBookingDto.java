package com.bagdouri.lastsecond.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FlightBookingDto {
    private Long id;
    private String customerFirstName;
    private String customerLastName;
    private String customerIdNumber;
    private String departureAirport;
    private LocalDateTime departureDateTime;
    private String arrivalAirport;
    private LocalDateTime arrivalDateTime;
    private Double price;
}
