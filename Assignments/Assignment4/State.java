package Assignment4;

public abstract class State {

    private static String RED = "RED";
    private static String YELLOW = "YELLOW";
    private static String GREEN = "GREEN";
    private static String WALK = "WALK";
    private static String DONT_WALK = "DONT WALK";
    private static int pedestrianFlashCtr = 2;
    private boolean isPedestrianWaiting = true;
    private String signalVehicles;

    public abstract void pedestrianWaiting();

    public abstract void timeout(Context state);

    public void setPedestrianWaiting(boolean pedestrianWaiting) {
        isPedestrianWaiting = pedestrianWaiting;
    }

    public boolean getPedestrianWaiting() {
        return isPedestrianWaiting;
    } 

    public void setSignalVehicles(String signal) {
        signalVehicles = signal;
    }

    public String getSignalVehicles() {
        return signalVehicles;
    }

    public int getFlashCtr() {
        return pedestrianFlashCtr;
    }

    public String getPedestrianSignalWalk() {
        return WALK;
    }

    public String getPedestrianSignalDontWalk() {
        return DONT_WALK;
    }

    public String getVehicleSignalGreen() {
        return GREEN;
    }

    public String getVehicleSignalYellow() {
        return YELLOW;
    }

    public String getVehicleSignalRed() {
        return RED;
    }
}