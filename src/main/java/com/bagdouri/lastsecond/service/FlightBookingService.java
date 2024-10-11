package com.bagdouri.lastsecond.service;

import com.bagdouri.lastsecond.dto.FlightBookingDto;
import com.bagdouri.lastsecond.error.FlightBookingNotFoundException;
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
    public FlightBookingDto updateFlightBooking(Long id, FlightBookingDto updatedFlightBooking) {
        FlightBookingDto existingBooking = getFlightBookingById(id)
                .orElseThrow(() -> new FlightBookingNotFoundException(id));

        existingBooking.setCustomerFirstName(updatedFlightBooking.getCustomerFirstName());
        existingBooking.setCustomerLastName(updatedFlightBooking.getCustomerLastName());
        existingBooking.setCustomerIdNumber(updatedFlightBooking.getCustomerIdNumber());
        existingBooking.setDepartureAirport(updatedFlightBooking.getDepartureAirport());
        existingBooking.setDepartureDateTime(updatedFlightBooking.getDepartureDateTime());
        existingBooking.setArrivalAirport(updatedFlightBooking.getArrivalAirport());
        existingBooking.setArrivalDateTime(updatedFlightBooking.getArrivalDateTime());
        existingBooking.setPrice(updatedFlightBooking.getPrice());

        return existingBooking;
    }

    // Delete flight booking
    public boolean deleteFlightBooking(Long id) {
        return flightBookings.removeIf(flightBooking -> flightBooking.getId().equals(id));
    }
}
