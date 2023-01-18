package Assignment1;

public class BreadChef extends Thread {
    //private int breadIngredient = 1;

    @Override
    public void run() {
        System.out.println("Bread Chef has eaten their PB and J!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
    
}