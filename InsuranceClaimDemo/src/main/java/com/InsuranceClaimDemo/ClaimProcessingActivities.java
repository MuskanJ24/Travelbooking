package com.InsuranceClaimDemo;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface ClaimProcessingActivities {
    @ActivityMethod
    void submitClaim(String claimId);
    @ActivityMethod
    void verifyDocuments(String claimId);
    @ActivityMethod
    void evaluateClaim(String claimId);
    @ActivityMethod
    void settleClaim(String claimId);
}

