package com.TravelBooking;

import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class TravelBookingWorker {

    public static void main(String[] args) {

        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);

        WorkerFactory factory = WorkerFactory.newInstance(client);
        Worker worker = factory.newWorker(TaskQueues.TRAVEL_BOOKING_TASK_QUEUE);

        worker.registerWorkflowImplementationTypes(TravelBookingWorkflowImpl.class);
        worker.registerActivitiesImplementations(new TravelBookingActivitiesImpl());

        factory.start();
    }
}
