package Assignment4;

public class Context {

    private State currentState;
    private State previousState;

    public Context() {
        currentState = new VehiclesEnabled(this);
        System.out.println("System starting ...");
        while(true) {
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