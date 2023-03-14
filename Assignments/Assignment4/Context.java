package Assignment4;

public class Context {

    private State currentState;

    public Context() {
        currentState = new VehiclesEnabled();
    }

    public void pedestrianWaiting(State state) {
        currentState.pedestrianWaiting();
        currentState = state;
    }

    public void timeout() {
        currentState.timeout(this);
    }
}