package Assignment4;

public abstract class State {

    public static String RED = "RED";
    public static String YELLOW = "YELLOW";
    public static String GREEN = "GREEN";
    public static String WALK = "WALK";
    public static String DONT_WALK = "DONT WALK";
    public boolean isPedestrianWaiting = true;
    public int pedestrianFlashCtr = 2;
    public String signalVehicles;

    public abstract void pedestrianWaiting();

    public abstract void timeout(Context state);
}