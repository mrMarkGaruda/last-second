package com.bagdouri.lastsecond.service;

import com.bagdouri.lastsecond.dto.FlightBookingDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightBookingService {
    private List<FlightBookingDto> bookings = new ArrayList<>();

    public FlightBookingDto createBooking(FlightBookingDto booking) {
        bookings.add(booking);
        return booking;
    }

    public Optional<FlightBookingDto> getBookingById(Long id) {
        return bookings.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    public List<FlightBookingDto> listAllBookings() {
        return bookings;
    }

    public FlightBookingDto updateBooking(Long id, FlightBookingDto updatedBooking) {
        Optional<FlightBookingDto> existingBooking = getBookingById(id);
        if (existingBooking.isPresent()) {
            FlightBookingDto booking = existingBooking.get();
            booking.setCustomerFirstName(updatedBooking.getCustomerFirstName());
            booking.setCustomerLastName(updatedBooking.getCustomerLastName());
            booking.setDepartureAirport(updatedBooking.getDepartureAirport());
            // Update other fields...
            return booking;
        }
        return null; // Handle properly with exceptions
    }

    public boolean deleteBooking(Long id) {
        return bookings.removeIf(b -> b.getId().equals(id));
    }
}
