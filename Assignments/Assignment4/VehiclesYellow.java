package Assignment4;

public class VehiclesYellow extends State {

    @Override
    public void timeout(Context state) {
        signalVehicles = YELLOW;
        System.out.println("Traffic light is: " + signalVehicles);
        for (int i = 1; i < 4; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Light has been " + signalVehicles + " for " + i + " seconds");
        }
        state.pedestrianWaiting(new PedestriansEnabled());
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Pedestrian waiting is: " + isPedestrianWaiting);
        isPedestrianWaiting = false;
    }
    
}