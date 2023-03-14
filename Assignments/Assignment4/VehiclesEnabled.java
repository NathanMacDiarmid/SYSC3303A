package Assignment4;

public class VehiclesEnabled extends State {

    @Override
    public void timeout(Context state) {
        System.out.println("Vehicles Enabled");
        state.pedestrianWaiting(new VehiclesGreen());
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Is pedestrian waiting? " + isPedestrianWaiting);
    }
}