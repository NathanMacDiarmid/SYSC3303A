package Assignment4;

public class PedestriansWalk extends State {

    @Override
    public void timeout(Context state) {
        signalVehicles = RED;
        System.out.println("Traffic light is: " + signalVehicles);
        System.out.println("Pedestrians can now walk");
        for (int i = 1; i < 16; i++) {
            System.out.println(WALK);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        state.pedestrianWaiting(new PedestriansFlash());
    }

    @Override
    public void pedestrianWaiting() {
        isPedestrianWaiting = false;
        System.out.println("Pedestrian waiting is: " + isPedestrianWaiting);
    }

}