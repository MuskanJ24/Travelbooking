package com.InsuranceClaimDemo;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface ClaimProcessingWorkflow {
    @WorkflowMethod
    void processClaim(String claimId);
}

