package com.InsuranceClaimDemo;

import io.temporal.api.common.v1.WorkflowExecution;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class ClaimApp {


    public static void main(String[] args) {

        System.out.println("Hello world!");
        // In the Java SDK, a stub represents an element that participates in
        // Temporal orchestration and communicates using gRPC.

        // A WorkflowServiceStubs communicates with the Temporal front-end service.
        WorkflowServiceStubs serviceStub = WorkflowServiceStubs.newLocalServiceStubs();

        // A WorkflowClient wraps the stub.
        // It can be used to start, signal, query, cancel, and terminate Workflows.
        WorkflowClient client = WorkflowClient.newInstance(serviceStub);

        // Workflow options configure  Workflow stubs.
        // A WorkflowId prevents duplicate instances, which are removed.
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(TaskQueues.INSURANCE_CLAIM_PROCESSING_TASK_QUEUE)
                .setWorkflowId("insuranceClaim-processing-workflow")
                .build();

        // WorkflowStubs enable calls to methods as if the Workflow object is local
        // but actually perform a gRPC call to the Temporal Service.
        ClaimProcessingWorkflow workflow = client.newWorkflowStub(ClaimProcessingWorkflow.class, options);

        // Configure the details for this money transfer request
        String claimId = UUID.randomUUID().toString().substring(0, 18);


        // Perform asynchronous execution.
        // This process exits after making this call and printing details.
        WorkflowExecution we = WorkflowClient.start(workflow::processClaim, claimId);

        System.out.printf("\nInsurance Claim Processing DEMO Initiating...\n\n");
        System.out.printf("Initiating claim for [claimId %s].\n\n", claimId);
        System.out.printf("[WorkflowID: %s]\n[RunID: %s]\n\n", we.getWorkflowId(), we.getRunId());
        System.exit(0);
    }
}