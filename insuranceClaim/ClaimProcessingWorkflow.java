
@WorkflowInterface
public interface ClaimProcessingWorkflow {
    @WorkflowMethod
    void processClaim(String claimId);
}

