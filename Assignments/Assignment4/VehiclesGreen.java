package Assignment4;

public class VehiclesGreen extends State {

    public VehiclesGreen(Context state) {
        state.getCurrentState().setSignalVehicles(state.getCurrentState().getVehicleSignalGreen());
    }

    @Override
    public void timeout(Context state) {
        System.out.println("Traffic light is: " + state.getPreviousState().getSignalVehicles());
        for (int i = 1; i < 11; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Light has been " + state.getPreviousState().getSignalVehicles() + " for " + i + " seconds");
        }
        state.pedestrianWaiting(new VehiclesYellow(state));
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Is pedestrian waiting? " + getPedestrianWaiting());
    }
    
}