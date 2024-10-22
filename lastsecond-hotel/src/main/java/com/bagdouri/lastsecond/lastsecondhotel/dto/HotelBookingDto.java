package com.bagdouri.lastsecond.lastsecondhotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelBookingDto {

    private Long id;
    private String customerFirstName;
    private String customerLastName;
    private String customerIdNumber;
    private String hotelName;
    private LocalDateTime checkInDateTime;
    private LocalDateTime checkOutDateTime;
    private double price;
}
