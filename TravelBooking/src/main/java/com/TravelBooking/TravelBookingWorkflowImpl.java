package com.TravelBooking;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class TravelBookingWorkflowImpl implements TravelBookingWorkflow {

    private final TravelBookingActivities activities = Workflow.newActivityStub(
            TravelBookingActivities.class,
            ActivityOptions.newBuilder()
                    .setStartToCloseTimeout(Duration.ofMinutes(2))
                    .build()
    );

    @Override
    public void bookTravel(String bookingId) {
        System.out.printf("Travel booking workflow started for BookingID: %s%n", bookingId);

        activities.bookHotel(bookingId);
        activities.bookFlight(bookingId);
        activities.bookCab(bookingId);
        activities.sendNotification(bookingId);

        System.out.println("Travel booking workflow completed.");
    }
}
