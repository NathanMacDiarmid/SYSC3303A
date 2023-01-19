package Assignment1;

public class JamChef extends Thread {
    private Agent agent;
    private int ingredient;

    public JamChef(Agent agent, int ingredient) {
        this.agent = agent;
        this.ingredient = ingredient;
    }

    @Override
    public void run() {
        int ingredient = 0;
        for (int i = 0; i < 10; i ++) {
            ingredient = agent.get();
            System.out.println(this.ingredient + "   " + ingredient);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
    
}
