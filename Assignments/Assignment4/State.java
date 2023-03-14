package Assignment4;

public abstract class State {

    public static int RED = 0;
    public static int YELLOW = 1;
    public static int GREEN = 2;
    public static boolean isPedestrianWaiting = true;
    public int signalVehicles = GREEN;

    public abstract void pedestrianWaiting();

    public abstract void timeout(Context state);
}