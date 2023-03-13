package Assignment4;

public abstract class State {

    private static String DONT_WALK = "DON\'T WALK";
    private static String RED = "RED";
    private static String YELLOW = "YELLOW";
    private static String GREEN = "GREEN";

    public State() {

    }

    public static start(Context state) {

    }

    public abstract void pedestrianWaiting(Context state);

    public abstract void timeout(Context state);

}