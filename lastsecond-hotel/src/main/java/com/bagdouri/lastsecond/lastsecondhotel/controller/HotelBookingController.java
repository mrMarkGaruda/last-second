package com.bagdouri.lastsecond.lastsecondhotel.controller;

import com.bagdouri.lastsecond.lastsecondhotel.dto.HotelBookingDto;
import com.bagdouri.lastsecond.lastsecondhotel.service.HotelBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotel-bookings")
public class HotelBookingController {

    private final HotelBookingService hotelBookingService;

    public HotelBookingController(HotelBookingService hotelBookingService) {
        this.hotelBookingService = hotelBookingService;
    }

    // Create a hotel booking
    @PostMapping
    public ResponseEntity<HotelBookingDto> createHotelBooking(@RequestBody HotelBookingDto hotelBookingDto) {
        HotelBookingDto createdBooking = hotelBookingService.createHotelBooking(hotelBookingDto);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    // Get a hotel booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<HotelBookingDto> getHotelBookingById(@PathVariable Long id) {
        Optional<HotelBookingDto> booking = hotelBookingService.getHotelBookingById(id);
        return booking.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // List all hotel bookings
    @GetMapping
    public ResponseEntity<List<HotelBookingDto>> listAllHotelBookings() {
        List<HotelBookingDto> bookings = hotelBookingService.listAllHotelBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    // Update a hotel booking
    @PutMapping("/{id}")
    public ResponseEntity<HotelBookingDto> updateHotelBooking(@PathVariable Long id, @RequestBody HotelBookingDto hotelBookingDto) {
        HotelBookingDto updatedBooking = hotelBookingService.updateHotelBooking(id, hotelBookingDto);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }

    // Delete a hotel booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotelBooking(@PathVariable Long id) {
        boolean deleted = hotelBookingService.deleteHotelBooking(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
