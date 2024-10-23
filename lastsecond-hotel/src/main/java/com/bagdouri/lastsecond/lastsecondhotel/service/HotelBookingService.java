package com.bagdouri.lastsecond.lastsecondhotel.service;

import com.bagdouri.lastsecond.lastsecondhotel.dto.HotelBookingDto;
import com.bagdouri.lastsecond.lastsecondhotel.model.HotelBooking;
import com.bagdouri.lastsecond.lastsecondhotel.repository.HotelBookingRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelBookingService {

    private final HotelBookingRepository hotelBookingRepository;

    public HotelBookingService(HotelBookingRepository hotelBookingRepository) {
        this.hotelBookingRepository = hotelBookingRepository;
    }

    // Convert DTO to Entity
    private HotelBooking toEntity(HotelBookingDto dto) {
        HotelBooking booking = new HotelBooking();
        booking.setId(dto.getId());
        booking.setCustomerFirstName(dto.getCustomerFirstName());
        booking.setCustomerLastName(dto.getCustomerLastName());
        booking.setCustomerIdNumber(dto.getCustomerIdNumber());
        booking.setHotelName(dto.getHotelName());
        booking.setCheckInDateTime(dto.getCheckInDateTime());
        booking.setCheckOutDateTime(dto.getCheckOutDateTime());
        booking.setPrice(dto.getPrice());
        return booking;
    }

    // Convert Entity to DTO
    private HotelBookingDto toDto(HotelBooking entity) {
        return new HotelBookingDto(
                entity.getId(),
                entity.getCustomerFirstName(),
                entity.getCustomerLastName(),
                entity.getCustomerIdNumber(),
                entity.getHotelName(),
                entity.getCheckInDateTime(),
                entity.getCheckOutDateTime(),
                entity.getPrice()
        );
    }

    // Create a hotel booking
    public HotelBookingDto createHotelBooking(HotelBookingDto hotelBookingDto) {
        HotelBooking hotelBooking = toEntity(hotelBookingDto);
        HotelBooking savedBooking = hotelBookingRepository.save(hotelBooking);
        return toDto(savedBooking);
    }

    // Get a hotel booking by ID
    public Optional<HotelBookingDto> getHotelBookingById(Long id) {
        return hotelBookingRepository.findById(id).map(this::toDto);
    }

    // List all hotel bookings
    public List<HotelBookingDto> listAllHotelBookings() {
        return hotelBookingRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // Update a hotel booking
    public HotelBookingDto updateHotelBooking(Long id, HotelBookingDto updatedBooking) {
        HotelBooking existingBooking = hotelBookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel booking not found with id: " + id));

        existingBooking.setCustomerFirstName(updatedBooking.getCustomerFirstName());
        existingBooking.setCustomerLastName(updatedBooking.getCustomerLastName());
        existingBooking.setCustomerIdNumber(updatedBooking.getCustomerIdNumber());
        existingBooking.setHotelName(updatedBooking.getHotelName());
        existingBooking.setCheckInDateTime(updatedBooking.getCheckInDateTime());
        existingBooking.setCheckOutDateTime(updatedBooking.getCheckOutDateTime());
        existingBooking.setPrice(updatedBooking.getPrice());

        return toDto(hotelBookingRepository.save(existingBooking));
    }

    // Delete a hotel booking
    public boolean deleteHotelBooking(Long id) {
        if (hotelBookingRepository.existsById(id)) {
            hotelBookingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
