package Assignment4;

public class Context {

    private State currentState;

    public Context() {
        currentState = new VehiclesEnabled();
        System.out.println("System starting ...");
        // Change to while true loop
        for (int i = 0; i < 8; i++) {
            currentState.timeout(this);
        }
    }

    public void pedestrianWaiting(State state) {
        currentState.pedestrianWaiting();
        currentState = state;
    }

    public void timeout() {
        currentState.timeout(this);
    }
}