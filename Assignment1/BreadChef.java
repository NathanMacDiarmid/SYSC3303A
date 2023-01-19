package Assignment1;

public class BreadChef extends Thread {
    private Agent agent;
    private int ingredient;

    public BreadChef(Agent agent, int ingredient) {
        this.agent = agent;
        this.ingredient = ingredient;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            agent.put(i);
            System.out.println(this.ingredient + "   " + i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
    
}