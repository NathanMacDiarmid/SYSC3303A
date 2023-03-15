package Assignment4;

public class Context {

    private State currentState;
    private State previousState;

    public Context() {
        currentState = new VehiclesEnabled(this);
        System.out.println("System starting ...");
        // TODO Change to while true loop
        for (int i = 0; i < 8; i++) {
            timeout();
        }
    }

    public void pedestrianWaiting(State state) {
        currentState.pedestrianWaiting();
        previousState = currentState;
        currentState = state;
    }

    public void timeout() {
        currentState.timeout(this);
    }

    public State getCurrentState() {
        return currentState;
    }

    public State getPreviousState() {
        return previousState;
    }
}