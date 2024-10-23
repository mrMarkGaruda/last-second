package com.bagdouri.lastsecond.lastsecondflight.repository;

import com.bagdouri.lastsecond.lastsecondflight.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {
}
