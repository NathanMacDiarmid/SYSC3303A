package Assignment1;

public class Agent {
    private boolean empty = false;
    private int ingredient;

    public synchronized int get() {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        empty = false;
        notifyAll();
        return ingredient;
    }

    public synchronized void put(int ingredient) {
        while(empty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.ingredient = ingredient;
        empty = true;
        notifyAll();
    }
}
