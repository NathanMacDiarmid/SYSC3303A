package Assignment1;

public class Agent extends Thread {
    private int firstIngredient;
    //private int secondIngredient;
    //private int thirdIngredient;

    public synchronized int get() {
        return this.firstIngredient;
    }

    public synchronized void put() {

    }
}
