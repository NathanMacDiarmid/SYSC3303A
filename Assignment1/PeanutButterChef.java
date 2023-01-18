package Assignment1;

public class PeanutButterChef extends Thread {

    @Override
    public void run() {
        System.out.println("Peanut Butter Chef has eaten their PB and J!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
    
}
