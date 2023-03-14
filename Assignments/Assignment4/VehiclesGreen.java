package Assignment4;

public class VehiclesGreen extends State {

    @Override
    public void timeout(Context state) {
        System.out.println("Vehicles green");
        state.pedestrianWaiting(new VehiclesYellow());
    }

    @Override
    public void pedestrianWaiting() {
        System.out.println("Pedestrian waiting is: " + isPedestrianWaiting);
    }
    
}