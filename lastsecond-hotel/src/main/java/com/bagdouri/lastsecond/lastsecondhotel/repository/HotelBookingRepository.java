package com.bagdouri.lastsecond.lastsecondhotel.repository;

import com.bagdouri.lastsecond.lastsecondhotel.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long> {
}
