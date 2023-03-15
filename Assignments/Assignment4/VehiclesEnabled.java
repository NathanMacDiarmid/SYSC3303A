package Assignment4;

public class VehiclesEnabled extends State {

    public VehiclesEnabled(Context state) {
        if (state.getCurrentState() != null) {
            state.getCurrentState().setPedestrianWaiting(true);
        }
    }

    @Override
    public void timeout(Context state) {
        System.out.println("Vehicles Enabled");
        state.pedestrianWaiting(new VehiclesGreen(state));
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Is pedestrian waiting? " + getPedestrianWaiting());
    }
}