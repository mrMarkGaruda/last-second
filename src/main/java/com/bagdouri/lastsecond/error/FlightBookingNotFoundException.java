package com.bagdouri.lastsecond.error;

public class FlightBookingNotFoundException extends RuntimeException {
    public FlightBookingNotFoundException(Long id) {
        super("Flight booking not found with id: " + id);
    }
}