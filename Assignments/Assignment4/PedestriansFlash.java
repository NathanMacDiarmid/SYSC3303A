package Assignment4;

public class PedestriansFlash extends State {

    public PedestriansFlash(Context state) {
        state.getCurrentState().setSignalVehicles(state.getCurrentState().getVehicleSignalRed());
        state.getCurrentState().setPedestrianWaiting(false);
    }

    @Override
    public void timeout(Context state) {
        System.out.println("Traffic light is: " + state.getPreviousState().getSignalVehicles());
        for (int i = getFlashCtr(); i >= 0; i--) {
            if (i % 2 == 0) {
                System.out.println(getPedestrianSignalDontWalk());
            } else {
                System.out.println();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        state.pedestrianWaiting(new VehiclesEnabled(state));
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Is pedestrian waiting? " + getPedestrianWaiting());
    }
}