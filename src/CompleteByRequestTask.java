public class CompleteByRequestTask implements Task {
    private boolean isFinished = false;
    private boolean trigger = false;
    private boolean executionStatus = false;

    @Override
    public void execute() {
        if (trigger) this.isFinished = true;
        executionStatus = true;
    }

    @Override
    public boolean isFinished() { return this.isFinished; }

    @Override
    public boolean getStatus() { return executionStatus; }

    public void complete() { trigger = true; }

}
