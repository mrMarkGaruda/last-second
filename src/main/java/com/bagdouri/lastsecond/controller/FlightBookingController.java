package com.bagdouri.lastsecond.controller;

import com.bagdouri.lastsecond.dto.FlightBookingDto;
import com.bagdouri.lastsecond.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class FlightBookingController {

    @Autowired
    private FlightBookingService bookingService;

    @PostMapping
    public FlightBookingDto createBooking(@RequestBody FlightBookingDto booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{id}")
    public Optional<FlightBookingDto> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping
    public List<FlightBookingDto> listAllBookings() {
        return bookingService.listAllBookings();
    }

    @PutMapping("/{id}")
    public FlightBookingDto updateBooking(@PathVariable Long id, @RequestBody FlightBookingDto updatedBooking) {
        return bookingService.updateBooking(id, updatedBooking);
    }

    @DeleteMapping("/{id}")
    public boolean deleteBooking(@PathVariable Long id) {
        return bookingService.deleteBooking(id);
    }
}
