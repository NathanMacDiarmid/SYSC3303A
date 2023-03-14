package Assignment4;

public class VehiclesYellow extends State {

    @Override
    public void timeout(Context state) {
        System.out.println("Vehicles yellow");
        state.pedestrianWaiting(new PedestriansEnabled());
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Pedestrian waiting is: " + isPedestrianWaiting);
        isPedestrianWaiting = false;
    }
    
}