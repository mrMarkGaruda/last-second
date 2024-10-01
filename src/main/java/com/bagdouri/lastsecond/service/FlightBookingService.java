package com.bagdouri.lastsecond.service;

import com.bagdouri.lastsecond.dto.FlightBookingDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightBookingService {

    private final List<FlightBookingDto> flightBookings = new ArrayList<>();

    // Create flight booking
    public FlightBookingDto createFlightBooking(FlightBookingDto flightBookingDto) {
        flightBookings.add(flightBookingDto);
        return flightBookingDto;
    }

    // Get flight booking by ID
    public Optional<FlightBookingDto> getFlightBookingById(Long id) {
        return flightBookings.stream()
                .filter(flightBooking -> flightBooking.getId().equals(id))
                .findFirst();
    }

    // List all flight bookings
    public List<FlightBookingDto> listAllFlightBookings() {
        return new ArrayList<>(flightBookings);
    }

    // Update flight booking
    public Optional<FlightBookingDto> updateFlightBooking(Long id, FlightBookingDto updatedFlightBooking) {
        Optional<FlightBookingDto> existingBooking = getFlightBookingById(id);
        existingBooking.ifPresent(booking -> {
            booking.setCustomerFirstName(updatedFlightBooking.getCustomerFirstName());
            booking.setCustomerLastName(updatedFlightBooking.getCustomerLastName());
            booking.setCustomerIdNumber(updatedFlightBooking.getCustomerIdNumber());
            booking.setDepartureAirport(updatedFlightBooking.getDepartureAirport());
            booking.setDepartureDateTime(updatedFlightBooking.getDepartureDateTime());
            booking.setArrivalAirport(updatedFlightBooking.getArrivalAirport());
            booking.setArrivalDateTime(updatedFlightBooking.getArrivalDateTime());
            booking.setPrice(updatedFlightBooking.getPrice());
        });
        return existingBooking;
    }

    // Delete flight booking
    public boolean deleteFlightBooking(Long id) {
        return flightBookings.removeIf(flightBooking -> flightBooking.getId().equals(id));
    }
}
