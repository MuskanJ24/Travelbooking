package com.TravelBooking;

import io.temporal.api.common.v1.WorkflowExecution;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

import java.util.UUID;

public class TravelBookingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Travel Booking System!");

        // Initialize Temporal service stub
        WorkflowServiceStubs serviceStub = WorkflowServiceStubs.newLocalServiceStubs();

        // Create Temporal Workflow client
        WorkflowClient client = WorkflowClient.newInstance(serviceStub);

        // Configure Workflow options
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(TaskQueues.TRAVEL_BOOKING_TASK_QUEUE)
                .setWorkflowId("travelBooking-workflow")
                .build();

        // Create Workflow stub
        TravelBookingWorkflow workflow = client.newWorkflowStub(TravelBookingWorkflow.class, options);

        // Generate a unique booking ID
        String bookingId = UUID.randomUUID().toString().substring(0, 18);

        // Start the Workflow asynchronously
        WorkflowExecution we = WorkflowClient.start(workflow::bookTravel, bookingId);

        // Log Workflow details
        System.out.printf("\nTravel Booking Process Initiating...\n\n");
        System.out.printf("Booking initiated for [BookingID %s].\n\n", bookingId);
        System.out.printf("[WorkflowID: %s]\n[RunID: %s]\n\n", we.getWorkflowId(), we.getRunId());

        // Exit the application
        System.exit(0);
    }
}
