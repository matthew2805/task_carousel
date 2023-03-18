public class CountDownTask implements Task {
    private int countDown;
    private boolean isFinished = false;
    private boolean executionStatus = false;

    public CountDownTask(int value) {
        this.countDown = Math.max(value, 0);
        if (value <= 0) this.isFinished = true;
    }

    public int getValue() { return this.countDown; }

    @Override
    public void execute() {
        if (countDown > 0) {
            countDown -= 1;
            if (countDown == 0) this.isFinished = true;
            executionStatus = true;
        } else executionStatus = false;
    }

    @Override
    public boolean isFinished() { return isFinished; }

    @Override
    public boolean getStatus() { return executionStatus; }
}
