package com.bagdouri.lastsecond.repository;

import com.bagdouri.lastsecond.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {
}
