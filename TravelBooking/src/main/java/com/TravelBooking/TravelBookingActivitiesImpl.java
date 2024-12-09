package com.TravelBooking;

public class TravelBookingActivitiesImpl implements TravelBookingActivities {

    @Override
    public void bookHotel(String bookingId) {
        System.out.printf("Hotel booking started for BookingID: %s%n", bookingId);
        // Simulate hotel booking logic
        System.out.printf("Hotel booking completed for BookingID: %s%n", bookingId);
    }

    @Override
    public void bookFlight(String bookingId) {
        System.out.printf("Flight booking started for BookingID: %s%n", bookingId);
        // Simulate flight booking logic
        System.out.printf("Flight booking completed for BookingID: %s%n", bookingId);
    }

    @Override
    public void bookCab(String bookingId) {
        System.out.printf("Cab booking started for BookingID: %s%n", bookingId);
        // Simulate cab booking logic
        System.out.printf("Cab booking completed for BookingID: %s%n", bookingId);
    }

    @Override
    public void sendNotification(String bookingId) {
        System.out.printf("Sending notification for BookingID: %s%n", bookingId);
        // Simulate notification logic
        System.out.printf("Notification sent for BookingID: %s%n", bookingId);
    }
}
