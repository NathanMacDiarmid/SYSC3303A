package Assignment4;

public class PedestriansEnabled extends State {

    @Override
    public void timeout(Context state) {
        System.out.println("Pedestrians enabled");
        state.pedestrianWaiting(new PedestriansWalk());
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Pedestrian waiting is: " + isPedestrianWaiting);
    }

}