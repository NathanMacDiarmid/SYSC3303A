package Assignment1;

public class JamChef extends Thread {

    @Override
    public void run() {
        System.out.println("Jam Chef has eaten their PB and J!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
    
}
