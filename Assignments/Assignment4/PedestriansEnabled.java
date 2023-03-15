package Assignment4;

public class PedestriansEnabled extends State {

    public PedestriansEnabled(Context state) {
        state.getCurrentState().setSignalVehicles(state.getCurrentState().getVehicleSignalRed());
    }

    @Override
    public void timeout(Context state) {
        System.out.println("Traffic light is: " + state.getPreviousState().getSignalVehicles());
        state.pedestrianWaiting(new PedestriansWalk(state));
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Is pedestrian waiting? " + getPedestrianWaiting());
    }

}