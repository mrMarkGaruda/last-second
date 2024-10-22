package com.bagdouri.lastsecond.lastsecondflight.service;

import com.bagdouri.lastsecond.lastsecondflight.dto.FlightBookingDto;
import com.bagdouri.lastsecond.lastsecondflight.error.FlightBookingNotFoundException;
import com.bagdouri.lastsecond.lastsecondflight.model.FlightBooking;
import com.bagdouri.lastsecond.lastsecondflight.repository.FlightBookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightBookingService {

    private final FlightBookingRepository flightBookingRepository;

    public FlightBookingService(FlightBookingRepository flightBookingRepository) {
        this.flightBookingRepository = flightBookingRepository;
    }

    // Map FlightBookingDto to FlightBooking entity
    private FlightBooking toEntity(FlightBookingDto dto) {
        FlightBooking booking = new FlightBooking();
        booking.setId(dto.getId());
        booking.setCustomerFirstName(dto.getCustomerFirstName());
        booking.setCustomerLastName(dto.getCustomerLastName());
        booking.setCustomerIdNumber(dto.getCustomerIdNumber());
        booking.setDepartureAirport(dto.getDepartureAirport());
        booking.setDepartureDateTime(dto.getDepartureDateTime());
        booking.setArrivalAirport(dto.getArrivalAirport());
        booking.setArrivalDateTime(dto.getArrivalDateTime());
        booking.setPrice(dto.getPrice());
        return booking;
    }

    // Map FlightBooking entity to FlightBookingDto
    private FlightBookingDto toDto(FlightBooking entity) {
        return new FlightBookingDto(
                entity.getId(),
                entity.getCustomerFirstName(),
                entity.getCustomerLastName(),
                entity.getCustomerIdNumber(),
                entity.getDepartureAirport(),
                entity.getDepartureDateTime(),
                entity.getArrivalAirport(),
                entity.getArrivalDateTime(),
                entity.getPrice()
        );
    }

    // Create flight booking
    public FlightBookingDto createFlightBooking(FlightBookingDto flightBookingDto) {
        FlightBooking flightBooking = toEntity(flightBookingDto);
        FlightBooking savedBooking = flightBookingRepository.save(flightBooking);
        return toDto(savedBooking);
    }

    // Get flight booking by ID
    public Optional<FlightBookingDto> getFlightBookingById(Long id) {
        return flightBookingRepository.findById(id).map(this::toDto);
    }

    // List all flight bookings
    public List<FlightBookingDto> listAllFlightBookings() {
        return flightBookingRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // Update flight booking
    public FlightBookingDto updateFlightBooking(Long id, FlightBookingDto updatedFlightBooking) {
        FlightBooking existingBooking = flightBookingRepository.findById(id)
                .orElseThrow(() -> new FlightBookingNotFoundException(id));

        existingBooking.setCustomerFirstName(updatedFlightBooking.getCustomerFirstName());
        existingBooking.setCustomerLastName(updatedFlightBooking.getCustomerLastName());
        existingBooking.setCustomerIdNumber(updatedFlightBooking.getCustomerIdNumber());
        existingBooking.setDepartureAirport(updatedFlightBooking.getDepartureAirport());
        existingBooking.setDepartureDateTime(updatedFlightBooking.getDepartureDateTime());
        existingBooking.setArrivalAirport(updatedFlightBooking.getArrivalAirport());
        existingBooking.setArrivalDateTime(updatedFlightBooking.getArrivalDateTime());
        existingBooking.setPrice(updatedFlightBooking.getPrice());

        FlightBooking savedBooking = flightBookingRepository.save(existingBooking);
        return toDto(savedBooking);
    }

    // Delete flight booking
    public boolean deleteFlightBooking(Long id) {
        if (flightBookingRepository.existsById(id)) {
            flightBookingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
