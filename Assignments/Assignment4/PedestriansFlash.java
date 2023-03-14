package Assignment4;

public class PedestriansFlash extends State {

    @Override
    public void timeout(Context state) {
        signalVehicles = RED;
        System.out.println("Traffic light is: " + signalVehicles);
        for (int i = pedestrianFlashCtr; i >= 0; i--) {
            if (i % 2 == 0) {
                System.out.println(DONT_WALK);
            } else {
                System.out.println();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        state.pedestrianWaiting(new VehiclesEnabled());
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Pedestrian waiting is: " + isPedestrianWaiting);
    }
}