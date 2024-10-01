package com.bagdouri.lastsecond.controller;

import com.bagdouri.lastsecond.dto.FlightBookingDto;
import com.bagdouri.lastsecond.service.FlightBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flight-bookings")
public class FlightBookingController {

    private final FlightBookingService flightBookingService;

    public FlightBookingController(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    // Create a flight booking
    @PostMapping
    public ResponseEntity<FlightBookingDto> createFlightBooking(@RequestBody FlightBookingDto flightBookingDto) {
        FlightBookingDto createdBooking = flightBookingService.createFlightBooking(flightBookingDto);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    // Get a flight booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<FlightBookingDto> getFlightBookingById(@PathVariable Long id) {
        Optional<FlightBookingDto> flightBooking = flightBookingService.getFlightBookingById(id);
        return flightBooking.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // List all flight bookings
    @GetMapping
    public ResponseEntity<List<FlightBookingDto>> listAllFlightBookings() {
        List<FlightBookingDto> flightBookings = flightBookingService.listAllFlightBookings();
        return new ResponseEntity<>(flightBookings, HttpStatus.OK);
    }

    // Update a flight booking
    @PutMapping("/{id}")
    public ResponseEntity<FlightBookingDto> updateFlightBooking(@PathVariable Long id, @RequestBody FlightBookingDto flightBookingDto) {
        Optional<FlightBookingDto> updatedBooking = flightBookingService.updateFlightBooking(id, flightBookingDto);
        return updatedBooking.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete a flight booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlightBooking(@PathVariable Long id) {
        boolean deleted = flightBookingService.deleteFlightBooking(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
