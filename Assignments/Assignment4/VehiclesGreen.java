package Assignment4;

public class VehiclesGreen extends State {

    @Override
    public void timeout(Context state) {
        signalVehicles = GREEN;
        System.out.println("Traffic light is: " + signalVehicles);
        for (int i = 1; i < 11; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Light has been " + signalVehicles + " for " + i + " seconds");
        }
        state.pedestrianWaiting(new VehiclesYellow());
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Is pedestrian waiting? " + isPedestrianWaiting);
    }
    
}