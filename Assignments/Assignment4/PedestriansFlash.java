package Assignment4;

public class PedestriansFlash extends State {

    @Override
    public void timeout(Context state) {
        System.out.println("Pedestrian light is flashing");
        state.pedestrianWaiting(new VehiclesEnabled());
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Pedestrian waiting is: " + isPedestrianWaiting);
        isPedestrianWaiting = true;
    }
}