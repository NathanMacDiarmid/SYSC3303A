package Assignment4;

public class PedestriansWalk extends State {

    @Override
    public void timeout(Context state) {
        System.out.println("Pedestrians are walking");
        state.pedestrianWaiting(new PedestriansFlash());
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Pedestrian waiting is: " + isPedestrianWaiting);
    }

}