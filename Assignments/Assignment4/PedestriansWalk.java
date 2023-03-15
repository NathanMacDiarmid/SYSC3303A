package Assignment4;

public class PedestriansWalk extends State {

    public PedestriansWalk(Context state) {
        state.getCurrentState().setSignalVehicles(state.getCurrentState().getVehicleSignalRed());
        state.getCurrentState().setPedestrianWaiting(false);
    }

    @Override
    public void timeout(Context state) {
        System.out.println("Traffic light is: " + state.getPreviousState().getSignalVehicles());
        System.out.println("Pedestrians can now walk");
        for (int i = 1; i < 16; i++) {
            System.out.println(getPedestrianSignalWalk());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        state.pedestrianWaiting(new PedestriansFlash(state));
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Is pedestrian waiting? " + getPedestrianWaiting());
    }

}