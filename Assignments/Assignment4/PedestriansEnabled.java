package Assignment4;

public class PedestriansEnabled extends State {

    @Override
    public void timeout(Context state) {
        signalVehicles = RED;
        System.out.println("Traffic light is: " + signalVehicles);
        state.pedestrianWaiting(new PedestriansWalk());
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Pedestrian waiting is: " + isPedestrianWaiting);
    }

}